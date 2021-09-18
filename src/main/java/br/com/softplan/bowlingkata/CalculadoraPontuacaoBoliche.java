package br.com.softplan.bowlingkata;

public class CalculadoraPontuacaoBoliche {

	private int[] jogadas;
	private int indexPrimeiraJogada;

	public int pontuacaoDoJogo(int[] jogadas) {
		this.jogadas = jogadas;
		int pontuacaoDoJogo = 0;

		for (indexPrimeiraJogada = 0; indexPrimeiraJogada < this.jogadas.length - 1; indexPrimeiraJogada += 2) {
			pontuacaoDoJogo += pontuacaoDaRodada();
		}
		return pontuacaoDoJogo;
	}


	private int pontuacaoDaRodada() {
		if (isRodadaComStrikeNoFinal()) {
			return pontuacaoRodadaComStrikeNoFinal();
		}

		if (isRodadaComStrike()) {
			int pontuacaoRodadaComStrike = pontuacaoRodadaComStrike();
			decrementaIndex();
			return pontuacaoRodadaComStrike;
		}

		if (isRodadaComSpare()) {
			return pontuacaoRodadaComSpare();
		}

		return pontuacaoRodadaNormal();
	}

	private boolean isRodadaComStrikeNoFinal() {
		return isRodadaComStrike() && this.indexPrimeiraJogada == this.jogadas.length - 3;
	}

	private int pontuacaoRodadaComStrikeNoFinal() {
		return primeiraJogadaDaRodada() + this.jogadas[this.indexPrimeiraJogada + 1] + this.jogadas[this.indexPrimeiraJogada + 2];
	}

	private int primeiraJogadaDaRodada() {
		return this.jogadas[this.indexPrimeiraJogada];
	}


	private boolean isRodadaComStrike() {
		return primeiraJogadaDaRodada() == 10;
	}

	private int pontuacaoRodadaComStrike() {
		return primeiraJogadaDaRodada() + this.jogadas[this.indexPrimeiraJogada + 1] + this.jogadas[this.indexPrimeiraJogada + 2];
	}

	private void decrementaIndex() {
		indexPrimeiraJogada--;
	}

	private boolean isRodadaComSpare() {
		return primeiraJogadaDaRodada() + this.jogadas[this.indexPrimeiraJogada + 1] == 10;
	}

	private int pontuacaoRodadaComSpare() {
		return pontuacaoRodadaNormal() + primeraJogadaDaProximaRodada();
	}

	private int primeraJogadaDaProximaRodada() {
		return this.jogadas[this.indexPrimeiraJogada + 2];
	}

	private int pontuacaoRodadaNormal() {
		return primeiraJogadaDaRodada() + this.jogadas[this.indexPrimeiraJogada + 1];
	}

}
