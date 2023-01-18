package com.iniflex.test;


import com.iniflex.test.controller.FuncionarioController;
import com.iniflex.test.model.Funcionario;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FuncionarioControllerTest {
    
    @Test
    @Order(1)
    void removerFuncionarioTest() {
        FuncionarioController funcionarios = new FuncionarioController();
        funcionarios.removerFuncionario("João");
        assertEquals(9, funcionarios.getFuncionarios().size());
    }
    
    @Test
    @Order(2)
    void aumentarSalarioTest() {
        FuncionarioController funcionarios1 = new FuncionarioController();
        FuncionarioController funcionarios2 = new FuncionarioController();

        funcionarios1.aumentarSalario(10);
        
        assertNotSame(funcionarios1, funcionarios2);
    }

    @Test
    @Order(3)
    void agruparFuncionariosPorFuncaoTest() {
        List<Funcionario> funcionarios = new ArrayList<>();
        FuncionarioController controller = new FuncionarioController();
        
        assertNotEquals(controller.getFuncionarios().equals(funcionarios), controller.agruparFuncionariosPorFuncao(funcionarios));
    }
}
