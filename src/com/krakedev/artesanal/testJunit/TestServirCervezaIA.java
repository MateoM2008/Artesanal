package com.krakedev.artesanal.testJunit;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaIA {

    // Tolerancia para comparar valores double
    private static final double DELTA = 0.0001;

    @Test
    public void testServirCervezaConSuficienteCantidadUsandoConstructorCompleto() {
        // Se crea la máquina usando el constructor con capacidad máxima.
        Maquina maquina = new Maquina("0001",
                "Cerveza Artesanal",
                "Cerveza rubia",
                0.05,
                10000
        );

        // Se llena la máquina utilizando un método disponible en la clase.
        maquina.llenarMaquina();

        // La capacidad actual queda en 9900 ml.
        // Se solicitan 1000 ml, por lo que hay suficiente cerveza.
        double valor = maquina.cervirCerveza(1000);

        // 1000 ml * 0.05 dólares/ml = 50 dólares.
        assertEquals(50.0, valor, DELTA);

        // Se debe haber descontado la cantidad servida.
        assertEquals(8900.0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirCervezaConSuficienteCantidadUsandoConstructorSimple() {
        // Se crea la máquina usando el segundo constructor.
        // Este constructor establece la capacidad máxima en 10000 ml.
        Maquina maquina = new Maquina("0002",
                "Cerveza Artesanal",
                "Cerveza roja",
                0.02
        );

        // Se llena la máquina.
        maquina.llenarMaquina();

        // Se solicitan 500 ml y existe suficiente cerveza disponible.
        double valor = maquina.cervirCerveza(500);

        // 500 ml * 0.02 dólares/ml = 10 dólares.
        assertEquals(10.0, valor, DELTA);

        // La cantidad actual debe disminuir de 9900 ml a 9400 ml.
        assertEquals(9400.0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testNoServirCuandoNoHaySuficienteCerveza() {
        // Se utiliza el constructor completo.
        Maquina maquina = new Maquina("0003",
                "Cerveza Artesanal",
                "Cerveza negra",
                0.03,
                5000
        );

        // La máquina comienza con 0 ml.
        assertEquals(0.0, maquina.getCantidadActual(), DELTA);

        // Se solicitan 500 ml, pero no hay cerveza disponible.
        double valor = maquina.cervirCerveza(500);

        // Al no poder servir cerveza, el valor a pagar debe ser 0.
        assertEquals(0.0, valor, DELTA);

        // La cantidad actual debe permanecer sin cambios.
        assertEquals(0.0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirExactamenteTodaLaCervezaDisponible() {
        // Se utiliza el constructor simple.
        Maquina maquina = new Maquina("0004",
                "Cerveza Artesanal",
                "Cerveza IPA",
                0.04
        );

        // La máquina queda con 9900 ml.
        maquina.llenarMaquina();

        // Se solicita exactamente toda la cantidad disponible.
        double valor = maquina.cervirCerveza(9900);

        // 9900 ml * 0.04 dólares/ml = 396 dólares.
        assertEquals(396.0, valor, DELTA);

        // Después de servir toda la cerveza, deben quedar 0 ml.
        assertEquals(0.0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirUnaCantidadMenorQueLaDisponible() {
        // Se utiliza el constructor completo.
        Maquina maquina = new Maquina("0005",
                "Cerveza Artesanal",
                "Cerveza ámbar",
                0.01,
                3000
        );

        // La máquina queda con 2900 ml.
        maquina.llenarMaquina();

        // Se solicitan 1000 ml, cantidad menor a la disponible.
        double valor = maquina.cervirCerveza(1000);

        // 1000 ml * 0.01 dólares/ml = 10 dólares.
        assertEquals(10.0, valor, DELTA);

        // Deben quedar 1900 ml.
        assertEquals(1900.0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testNoServirCuandoLaCantidadSolicitadaSuperaLaDisponible() {
        // Se utiliza el constructor simple.
        Maquina maquina = new Maquina("0006",
                "Cerveza Artesanal",
                "Cerveza lager",
                0.05
        );

        // La máquina queda con 9900 ml.
        maquina.llenarMaquina();

        // Se guardan los 9900 ml para comprobar que no cambien.
        double cantidadAntes = maquina.getCantidadActual();

        // Se solicitan 10000 ml, pero solo hay 9900 ml disponibles.
        double valor = maquina.cervirCerveza(10000);

        // No se debe cobrar porque no se pudo servir la cantidad solicitada.
        assertEquals(0.0, valor, DELTA);

        // La cantidad disponible debe permanecer intacta.
        assertEquals(cantidadAntes, maquina.getCantidadActual(), DELTA);
    }
}


