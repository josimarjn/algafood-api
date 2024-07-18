package com.algaworks.algafood_api;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
public class Parcelamento {

    private Integer numeroParcela;
    private Double valorTotalCompra;
    private LocalDateTime dataVencimento;
    private static int parcela;

    public static List<Parcelamento> of(Integer numeroParcelas, Double valorTotal, LocalDateTime dataVencimento){
        parcela = 1;
        List<Parcelamento> parcelas = new ArrayList<>();
        BigDecimal valorRestante = new BigDecimal(valorTotal);

        do {
            BigDecimal valorParcela = new BigDecimal(valorTotal).divide(new BigDecimal(numeroParcelas), 2, RoundingMode.HALF_EVEN);
            parcelas.add(new Parcelamento(
                    parcela==numeroParcelas ? valorRestante.doubleValue() : valorParcela.doubleValue(),
                    dataVencimento = dataVencimento.plusMonths(1)));
            valorRestante = valorRestante.subtract(valorParcela);
        }while (parcela <= numeroParcelas);
        return parcelas;
    }

    private Parcelamento(Double valorTotal, LocalDateTime dataVencimento){
        this.numeroParcela = parcela++;
        this.valorTotalCompra = valorTotal;
        this.dataVencimento = dataVencimento;
    }

    public static void main(String[] args) {
        List<Parcelamento> parcelas = Parcelamento.of(3, 12.00, LocalDateTime.now());
        parcelas.forEach(System.out::println);
    }
}
