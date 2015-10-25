<?php
  /**
  *
  */
  class Stores_Model extends CI_Model
  {

    function __construct()
    {
      parent::__construct();
      $this->load->database(); //Cargar base de datos.
    }

    public function getAllStores()
    {
      $sql = "SELECT * from cg_store ORDER BY store_name";

      $query = $this->db->query($sql);

      if($query->num_rows() > 0){
        return $query->result();
      }
    }
  }
?>