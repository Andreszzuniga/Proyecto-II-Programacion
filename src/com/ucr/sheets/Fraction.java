package com.ucr.sheets;

public class Fraction {
  // Definimos los atributos de una fracción.

  /** Numerador de la fracción. */
  private long numerador;
  /** Denominador de la fracción. */
  private long denominador;

  /**
   * Constructor de la clase.
   * @param numerador  Numerador de la fracción.
   * @param denominador Denominador de la fracción y nunca puede ser 0.
   */
  public Fraction(final long numerador, final long denominador) {
    // Asignación del valor del numerador.
    this.numerador = numerador;

    // Asignación del valor del denominador.
    if (denominador == 0) {
      this.denominador = 1;
    } else {
      this.denominador = denominador;
    }

    // Si el denominador es negativo.
    if (this.denominador < 0) {
      this.numerador *= -1;
      this.denominador *= -1;
    }

    // Se simplifica la fracción.
    simplificar();
  }

  private long maximoComunDivisor(final long a, final long b) {
    long tmpA = a;
    long tmpB = b;
    while (tmpB != 0) {
      long tmp = tmpB;
      tmpB = tmpA % tmpB;
      tmpA = tmp;
    }

    return tmpA;
  }

  private void simplificar() {
    long mcd = maximoComunDivisor(this.numerador, this.denominador);
    if (mcd != 0) {
      this.numerador /= mcd;
      this.denominador /= mcd;
    }
  }

  /**
   * Suma los valores de other a esta fracción.
   * @param other Fracción a sumar.
   */
  public void sum(final Fraction other) {
    long newNumerador = (this.numerador * other.denominador)
      + (other.numerador * this.denominador);
    long newDenominador = this.denominador * other.denominador;
    this.numerador = newNumerador;
    this.denominador = newDenominador;
    simplificar();
  }

  /**
   * Transforma la fracción a una representación en formato String.
   */
  @Override
  public String toString() {
    return this.numerador + "/" + this.denominador;
  }
}
