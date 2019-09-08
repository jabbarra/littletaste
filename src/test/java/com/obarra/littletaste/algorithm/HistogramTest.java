package com.obarra.littletaste.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class HistogramTest {

    @Test
    public void printHistogramHorizontal() {
        int[] values = {1, 2, 1, 9};
        Histogram.printHistogramHorizontal(values);
    }

    @Test
    public void printHistogramRowByRow() {
        int[] values = {1, 2, 1, 9};
        Histogram.printHistogramRowByRow(values);
    }

    @Test
    public void generateMatrixHistogramRowByRow() {
        int[] values = {1, 2, 1, 9};
        char[][] matrixHistogram = Histogram.generateMatrixHistogramRowByRow(values);
        Histogram.printMatrixHistogram(matrixHistogram);
    }

    @Test
    public void printMatrixHistogram() {
        char[][] matrixHistogram = new char[2][3];
        matrixHistogram[0][0] = matrixHistogram[0][1] = matrixHistogram[0][2] = 'm';
        matrixHistogram[1][1] = 'm';

        Histogram.printMatrixHistogram(matrixHistogram);
    }
}