package com.ucr.sheets;

public class Controller {
  private int[][] sheet;

    // Constructor
  public Controller(int[][] sheet) {
      this.sheet = sheet;
  }

    // Sumar fila o columna
  public int sumar(String tipo, int index, int inicio, int fin) {
    int suma = 0;
    if (tipo.equalsIgnoreCase("fila")) {
      for (int j = inicio; j <= fin; j++) {
        suma += sheet[index][j];
      }
   } else if (tipo.equalsIgnoreCase("columna")) {
      for (int i = inicio; i <= fin; i++) {
        suma += sheet[i][index];
      }
    }
      return suma;
    }

    // Multiplicar fila o columna
    public int multiplicar(String tipo, int index, int inicio, int fin) {
        int producto = 1;
        if (tipo.equalsIgnoreCase("fila")) {
            for (int j = inicio; j <= fin; j++) {
                producto *= sheet[index][j];
            }
        } else if (tipo.equalsIgnoreCase("columna")) {
            for (int i = inicio; i <= fin; i++) {
                producto *= sheet[i][index];
            }
        }
        return producto;
    }

    // Maximo
    public int maximo(String tipo, int index, int inicio, int fin) {
        int max = Integer.MIN_VALUE;
        if (tipo.equalsIgnoreCase("fila")) {
            for (int j = inicio; j <= fin; j++) {
                max = Math.max(max, sheet[index][j]);
            }
        } else {
            for (int i = inicio; i <= fin; i++) {
                max = Math.max(max, sheet[i][index]);
            }
        }
        return max;
    }
    //Minimo
    public int minimo(String tipo, int index, int inicio, int fin) {
        int min = Integer.MAX_VALUE;
        if (tipo.equalsIgnoreCase("fila")) {
            for (int j = inicio; j <= fin; j++) {
                min = Math.min(min, sheet[index][j]);
            }
        } else {
            for (int i = inicio; i <= fin; i++) {
                min = Math.min(min, sheet[i][index]);
            }
        }
        return min;
    }

    // Promedio
    public double promedio(String tipo, int index, int inicio, int fin) {
        int suma = sumar(tipo, index, inicio, fin);
        int cantidad = fin - inicio + 1;
        return (double) suma / cantidad;
    }

}
