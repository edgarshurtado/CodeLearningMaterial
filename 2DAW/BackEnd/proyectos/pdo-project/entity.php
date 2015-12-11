<?php
/**
*
*/
class Shop
{
    private $name;
    private $zone;
    private $adress;
    private $city;
    private $phone;
    private $email;

    public function __GET($k)
    {
        return $this->$k;
    }

    public function __SET($k, $v)
    {
        $this->$k = $v;
    }
}
?>