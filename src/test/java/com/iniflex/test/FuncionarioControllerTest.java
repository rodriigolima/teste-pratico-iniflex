package com.iniflex.test;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FuncionarioControllerTest {

    @Test
    @Order(1)
    void inserindoFuncionarioTest() {
       
    }
    
    @Test
    @Order(2)
    void inserindoFuncionariosToListaTest() {
        
    }
}
