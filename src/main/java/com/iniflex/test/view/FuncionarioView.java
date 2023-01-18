package com.iniflex.test.view;

import com.iniflex.test.model.Funcionario;
import com.iniflex.test.model.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FuncionarioView {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,##0.00");

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {


        System.out.println("+-----------------+------------------------+--------------+----------------+");
        System.out.println("| Nome            | Data Nascimento        | Salário      | Função         |");
        System.out.println("+-----------------+------------------------+--------------+----------------+");
        for (Funcionario f : funcionarios) {
            System.out.printf("| %-15s | %-22s | %-12s | %-14s |%n", f.getNome(), DATE_FORMAT.format(
                    f.getDataNascimento()), DECIMAL_FORMAT.format(f.getSalario()), f.getFuncao());
        }
        System.out.println("+-----------------+------------------------+--------------+----------------+");
    }

    public void imprimirFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        System.out.println("Funcionários, agrupados por função. ");
        System.out.println("+---------------+------------+");
        System.out.println("| Função        | Nome       |");
        System.out.println("+---------------+------------+");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            for (Funcionario f : entry.getValue()) {
                System.out.printf("| %-13s | %-10s |%n", entry.getKey(), f.getNome());
            }
        }
        System.out.println("+---------------+------------+");
    }

    public void imprimirFuncionariosFazAnivMes10e12(List<Funcionario> funcionarios) {
        System.out.println("Funcionários que fazem aniversário no mês 10 e 12 ");

        // 3.8 — Imprimir os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("+-------------+-----------------+");
        System.out.println("| Nome        | Aniversário     |");
        System.out.println("+-------------+-----------------+");
        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12) {
                System.out.printf("| %-11s | %-15s |%n", f.getNome(), DATE_FORMAT.format(f.getDataNascimento()));
            }
        }
        System.out.println("+-------------+-----------------+");
    }

    public void imprimirFuncionarioComMaiorIdade(List<Funcionario> funcionarios) {
        // 3.9 — Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        Funcionario funcionarioMaisVelho = funcionarios.get(0);
        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().isBefore(funcionarioMaisVelho.getDataNascimento())) {
                funcionarioMaisVelho = f;
            }
        }
        System.out.println("O funcionário com a maior idade é : ");

        System.out.println("+-----------------+-------+");
        System.out.println("| Funcionário     | Idade |");
        System.out.println("+-----------------+-------+");
        System.out.printf("| %-15s | %-5d |%n", funcionarioMaisVelho.getNome(), funcionarioMaisVelho.getDataNascimento()
                .until(LocalDate.now()).getYears());
        System.out.println("+-----------------+-------+");
    }

    public void imprimirPessoasPorOrdemAlfab(List<Funcionario> funcionarios) {
        System.out.println("Lista de funcionários por ordem alfabética ");

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética
        System.out.println("+---------------+");
        System.out.println("| Nome          |");
        System.out.println("+---------------+");
        funcionarios.sort(Comparator.comparing(Pessoa::getNome));
        for (Funcionario f : funcionarios) {
            System.out.printf("| %-13s |%n", f.getNome());
        }
        System.out.println("+---------------+");
    }

    public void imprimirSalarioTotalDosFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("Total dos salários dos funcionários. sem o joão** e com o aumento de 10%");

        // 3.11 – Imprimir o total dos salários dos funcionários.
        BigDecimal salarioTotal = new BigDecimal(0);
        for (Funcionario f : funcionarios) {
            salarioTotal = salarioTotal.add(f.getSalario());
        }

        System.out.println("+---------------------------------------+");
        System.out.println("| Total dos salários dos funcionários   |");
        System.out.println("+---------------------------------------+");
        System.out.printf("| %-37s |%n", DECIMAL_FORMAT.format(salarioTotal));
        System.out.println("+---------------------------------------+");
    }

    public void imprimirQuantSalarioMinPorFuncionario(List<Funcionario> funcionarios) {
        System.out.println("Quantos salários mínimos ganha cada funcionário, " +
                "considerando que o salário mínimo é R$1212.00 ");

        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        System.out.println("+--------------------+------------------+");
        System.out.println("| Funcionário        | Salários Mínimos |");
        System.out.println("+--------------------+------------------+");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        for (Funcionario f : funcionarios) {
            BigDecimal salarioMinimoPorFuncionario = f.getSalario().divide(salarioMinimo, 0, RoundingMode.HALF_UP);
            System.out.printf("| %-18s | %-16s |%n", f.getNome(), salarioMinimoPorFuncionario);
        }
        System.out.println("+--------------------+------------------+");
    }
}
