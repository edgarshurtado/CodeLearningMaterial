
public class Entity {
	private float[] position;
	private boolean isStatic;
	private boolean isVisible;
	private boolean isKinematic;
	private long ID;
	private static long nObjects = 0; //class attribute, not object attribute
	public Entity(){
		this.position[0]=0;
		this.position[1]=0;
		this.isStatic = true;
		this.isKinematic = true;
		Entity.nObjects = Entity.nObjects + 1;
		this.ID = Entity.nObjects;
		
	}
	
	public void print(){
		
	}
	
	public void changePosition(){
		
	}
	
	public boolean isStatic(){
		return this.isStatic;
	}
	
	public boolean isVisible(){
		return this.isVisible;
	}
	
	public boolean isKinematic() {
		return this.isKinematic;
	}
	
	public long getID() {
		return this.ID;
	}
}
