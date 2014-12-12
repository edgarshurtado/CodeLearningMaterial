# FINAL MINIPROJECT - Rice Rocks. A version of Asteroids
import simplegui
import math
import random

# globals for user interface
WIDTH = 800
HEIGHT = 600
score = 0
lives = 3
time = 0.5
started = False
ACCEL_FRICTION_CONSTANT = 0.1
VEL_FRICTION_CONSTANT = 0.99
CANVAS_SIZE = [WIDTH, HEIGHT]
CANVAS_CENTER = [WIDTH/2, HEIGHT/2]

class ImageInfo:
    def __init__(self, center, size, radius = 0, lifespan = None, animated = False):
        self.center = center
        self.size = size
        self.radius = radius
        if lifespan:
            self.lifespan = lifespan
        else:
            self.lifespan = float('inf')
        self.animated = animated

    def get_center(self):
        return self.center

    def get_size(self):
        return self.size

    def get_radius(self):
        return self.radius

    def get_lifespan(self):
        return self.lifespan

    def get_animated(self):
        return self.animated

    
# art assets created by Kim Lathrop, may be freely re-used in non-commercial projects, please credit Kim
    
# debris images - debris1_brown.png, debris2_brown.png, debris3_brown.png, debris4_brown.png
#                 debris1_blue.png, debris2_blue.png, debris3_blue.png, debris4_blue.png, debris_blend.png
debris_info = ImageInfo([320, 240], [640, 480])
debris_image = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/debris2_blue.png")

# nebula images - nebula_brown.png, nebula_blue.png
nebula_info = ImageInfo([400, 300], [800, 600])
nebula_image = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/nebula_blue.f2014.png")

# splash image
splash_info = ImageInfo([200, 150], [400, 300])
splash_image = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/splash.png")

# ship image
ship_no_thrust_center_pos = [45,45]
ship_with_thrust_center_pos = [135,45]
ship_info = ImageInfo(ship_no_thrust_center_pos, [90, 90], 35)
ship_image = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/double_ship.png")

# missile image - shot1.png, shot2.png, shot3.png
missile_info = ImageInfo([5,5], [10, 10], 3, 15)
missile_image = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/shot2.png")

# asteroid images - asteroid_blue.png, asteroid_brown.png, asteroid_blend.png
asteroid_info = ImageInfo([45, 45], [90, 90], 40)
asteroid_image = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/asteroid_blue.png")

# animated explosion - explosion_orange.png, explosion_blue.png, explosion_blue2.png, explosion_alpha.png
explosion_info = ImageInfo([64, 64], [128, 128], 17, 24, True)
explosion_image = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/explosion_alpha.png")

# sound assets purchased from sounddogs.com, please do not redistribute
soundtrack = simplegui.load_sound("http://commondatastorage.googleapis.com/codeskulptor-assets/sounddogs/soundtrack.mp3")
missile_sound = simplegui.load_sound("http://commondatastorage.googleapis.com/codeskulptor-assets/sounddogs/missile.mp3")
missile_sound.set_volume(.5)
ship_thrust_sound = simplegui.load_sound("http://commondatastorage.googleapis.com/codeskulptor-assets/sounddogs/thrust.mp3")
explosion_sound = simplegui.load_sound("http://commondatastorage.googleapis.com/codeskulptor-assets/sounddogs/explosion.mp3")

# helper functions to handle transformations
def angle_to_vector(ang):
    return [math.cos(ang), math.sin(ang)]

def dist(p,q):
#    p = p.get_position()
#    q = q.get_position()
    return math.sqrt((p[0] - q[0]) ** 2+(p[1] - q[1]) ** 2)

def draw_set(group,canvas):
    group_set = set(group)
    for object in group_set:
        object.draw(canvas)
        moreThanLifespan = object.update()
        if moreThanLifespan:
            group.remove(object)
              
def group_collide(group, other_object):
    #check if 2 objects collides and if they do deletes the one of the group
    group_set = set(group)
    collision = False
    for someObject in group_set:
        if someObject.collide(other_object):
            group.remove(someObject)
            collision = True  
    if collision:
        return True
    else:
        return False
 
def group_group_collide (group1, group2):
    group_set = set(group2)
    hit = False
    for object2 in group_set:
        if group_collide(group1,object2):
            group2.remove(object2)   
            hit = True 
    if hit:
        return True
    else:
        return False

def new_game():
    global lives, score, started
    started = True
    lives = 3
    score = 0
    soundtrack.play()

def end_game():
    global rock_group, missile_group, started
    missile_group = set([])
    rock_group = set([])
    started = False
    soundtrack.pause()
    soundtrack.rewind()
    
# Ship class
class Ship:
    def __init__(self, pos, vel, angle, image, info):
        self.pos = [pos[0],pos[1]]
        self.vel = [vel[0],vel[1]]
        self.thrust = False
        self.angle = angle
        self.angle_vel = 0
        self.image = image
        self.image_center = info.get_center()
        self.image_size = info.get_size()
        self.radius = info.get_radius()
        self.info = info
        
    def get_position(self):
        return self.pos
    
    def get_radius(self):
        return self.radius
    
    def draw(self,canvas):
        canvas.draw_image(ship_image, ship_info.get_center(), self.info.get_size(),
                          self.pos, ship_info.get_size(), self.angle)

    def thrusting(self,boolean):
        #sets the value of the boolean variable thrust
        self.thrust = boolean
        
        #play the sound of the ship
        if boolean:
            ship_thrust_sound.play()
        else:
            ship_thrust_sound.pause()
            ship_thrust_sound.rewind()
 
    def fire(self):
        #info needed to draw the missile in the right position
        ship_angle_vector = angle_to_vector(self.angle)
        ship_radius = (self.info.get_size()[0]/2, self.info.get_size()[1]/2)
        missile_pos = [self.pos[0]+ ship_radius[0]*ship_angle_vector[0],
                       self.pos[1]+ ship_radius[1]*ship_angle_vector[1]]
        
        #Compute the vel of the missile
        missileConstant = 15 	#a constat to give a proper fire vel to the missile through the canon
        #The global vel of the missile it's the combination of the vel of the ship when it's fired
        #and the fire vel
        missile_vel = [self.vel[0] + ship_angle_vector[0]*missileConstant, 
                       self.vel[1] + ship_angle_vector[1]*missileConstant]
        
        #Creat the missile
        a_missile = Sprite(missile_pos, missile_vel, 0, 0, missile_image, missile_info, missile_sound)
        missile_group.add(a_missile)
        
    def rotation(self, radians):
        #changes the angle of the ship
        self.angle_vel = radians
    
    def update(self):
        #Updates the angle of the ship
        self.angle += self.angle_vel
        #Updates the velocity if the ship is thrusting
        if self.thrust:
            accel = angle_to_vector(self.angle)
            self.vel[0] += accel[0] * ACCEL_FRICTION_CONSTANT
            self.vel[1] += accel[1] * ACCEL_FRICTION_CONSTANT
        
        self.vel[0] *= VEL_FRICTION_CONSTANT
        self.vel[1] *= VEL_FRICTION_CONSTANT
        #Update the position of the ship and keeps it in the canvas
        self.pos[0] = (self.pos[0] + self.vel[0]) % WIDTH
        self.pos[1] = (self.pos[1] + self.vel[1]) % HEIGHT
 
# Sprite class
class Sprite:
    def __init__(self, pos, vel, ang, ang_vel, image, info, sound = None):
        self.pos = [pos[0],pos[1]]
        self.vel = [vel[0],vel[1]]
        self.angle = ang
        self.angle_vel = ang_vel
        self.image = image
        self.image_center = info.get_center()
        self.image_size = info.get_size()
        self.radius = info.get_radius()
        self.lifespan = info.get_lifespan()
        self.animated = info.get_animated()
        self.age = 0
        self.info = info
        if sound:
            sound.rewind()
            sound.play()
   
    def get_position(self):
        return self.pos
    
    def get_radius(self):
        return self.radius
    
    def draw(self, canvas):
        canvas.draw_image(self.image, self.info.get_center(), self.info.get_size(),
                          self.pos, self.info.get_size(), self.angle)
    
    def update(self):
        self.angle += self.angle_vel
        self.pos[0] += self.vel[0]
        self.pos[1] += self.vel[1] 
        #Stay in the canvas
        self.pos[0] %= WIDTH
        self.pos[1] %= HEIGHT
        
        #lifespan
        self.age += 1
        if self.age > self.lifespan:
            return True
        else:
            return False
        
    def collide(self,other_object):
        if dist(self.get_position(), other_object.get_position()) < (self.get_radius() + other_object.get_radius()):
            return True

def draw(canvas):
    global time, lives, score, started
    
    # animiate background
    time += 1
    wtime = (time / 4) % WIDTH
    center = debris_info.get_center()
    size = debris_info.get_size()
    canvas.draw_image(nebula_image, nebula_info.get_center(), nebula_info.get_size(), [WIDTH / 2, HEIGHT / 2], [WIDTH, HEIGHT])
    canvas.draw_image(debris_image, center, size, (wtime - WIDTH / 2, HEIGHT / 2), (WIDTH, HEIGHT))
    canvas.draw_image(debris_image, center, size, (wtime + WIDTH / 2, HEIGHT / 2), (WIDTH, HEIGHT))

    # draw ship and sprites
    my_ship.draw(canvas)
    if not started:
        #rock_group=([])
        #missile_group=([])
        canvas.draw_image(splash_image, splash_info.get_center(), splash_info.get_size(),[WIDTH / 2, HEIGHT / 2],
                          [splash_info.get_size()[0], splash_info.get_size()[1]])
    
    draw_set(rock_group,canvas)
    draw_set(missile_group, canvas)

    
    # update ship and sprites
    my_ship.update()
    #a_missile.update()
    
    #collision updates
    collision = group_collide(rock_group, my_ship)
    hit = group_group_collide(rock_group, missile_group)
    #Print score/Lives
    if collision:
        lives -= 1
        if lives == 0:
            end_game()
            
    scoreTxt="Score: " + str(score)
    livesTxt="Lives: " + str(lives)
    
    if hit:
        score += 10
   
    txtSize=30
    canvas.draw_text(scoreTxt, (1*WIDTH/100, txtSize), txtSize, 'Red')
    canvas.draw_text(livesTxt, (85*WIDTH/100, txtSize), txtSize, 'Red')
    
#keyboard input handlers
def key_handler(key):
    if key == simplegui.KEY_MAP["right"]:
        my_ship.rotation(0.1)
    if key == simplegui.KEY_MAP["left"]:
        my_ship.rotation(-0.1)
    if key == simplegui.KEY_MAP["up"]:
        ship_info.center = ship_with_thrust_center_pos
        my_ship.thrusting(True)
    if key == simplegui.KEY_MAP["space"]:
        my_ship.fire()
        
def key_up_handler(key):
    if key == simplegui.KEY_MAP["right"] or key == simplegui.KEY_MAP["left"]:
        my_ship.rotation(0)
    if key == simplegui.KEY_MAP["up"]:
        ship_info.center = ship_no_thrust_center_pos
        my_ship.thrusting(False)

# timer handler that spawns a rock    
def rock_spawner():
    global rock_group
    if len(rock_group) < 12 and started:
        angular_vel = random.choice([-0.05, -0.01, 0.01, 0.05])
        pos=[random.randrange(0, WIDTH), random.randrange(0, HEIGHT)]
        if dist(pos, my_ship.get_position()) > asteroid_info.get_radius() * 2:
            vel = [random.choice([-2, -1, 1, 2]), random.choice([-2,-1, 1, 2])]
            a_rock = Sprite(pos, vel, 0, angular_vel, asteroid_image, asteroid_info)
            rock_group.add(a_rock)

#mouse input handler
def mouse_handler(position):
    new_game()   
    
# initialize frame
frame = simplegui.create_frame("Asteroids", WIDTH, HEIGHT)

# initialize ship and two sprites
my_ship = Ship(CANVAS_CENTER, [0, 0], 0, ship_image, ship_info)
end_game()
#rock_group=set([])
#missile_group=set([])

# register handlers
frame.set_draw_handler(draw)
frame.set_keydown_handler(key_handler)
frame.set_keyup_handler(key_up_handler)
frame.set_mouseclick_handler(mouse_handler)
timer = simplegui.create_timer(1000.0, rock_spawner)

# get things rolling
timer.start()
frame.start()


