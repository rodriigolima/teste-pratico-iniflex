package com.iniflex.test;

import com.iniflex.test.controller.FuncionarioController;
import com.iniflex.test.view.FuncionarioView;



public class Principal {

    public static void main(String[] args) {

        FuncionarioController funcionarios = new FuncionarioController();
        FuncionarioView view = new FuncionarioView();

        // 3.2 — Remover o funcionário “João” da lista.
        funcionarios.removerFuncionario("João");


        /*
         * 3.3 — Imprimir todos os funcionários com todas as suas informações, sendo que:
         * informação de data deve ser exibido no formato dd/mm/aaaa;
         * informação de valor numérico deve ser exibida no formatado
         * com separador de milhar como ponto e decimal como vírgula.
         */
        System.out.println("Lista de funcionários sem o funcionário João. ");
        view.imprimirFuncionarios(funcionarios.getFuncionarios());

        funcionarios.aumentarSalario(10);

        System.out.println("Lista de funcionários atualizados com os 10%. ");
        view.imprimirFuncionarios(funcionarios.getFuncionarios());

        view.imprimirFuncionariosPorFuncao(funcionarios
                .agruparFuncionariosPorFuncao(funcionarios.getFuncionarios()));

        view.imprimirFuncionariosFazAnivMes10e12(funcionarios.getFuncionarios());

        view.imprimirFuncionarioComMaiorIdade(funcionarios.getFuncionarios());

        view.imprimirPessoasPorOrdemAlfab(funcionarios.getFuncionarios());

        view.imprimirSalarioTotalDosFuncionarios(funcionarios.getFuncionarios());

        view.imprimirQuantSalarioMinPorFuncionario(funcionarios.getFuncionarios());


    }

}  
