package br.com.softplan.bowlingkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraPontuacaoBolicheTest {

	private CalculadoraPontuacaoBoliche calculadora;

	@BeforeEach
	void setUp() {
		calculadora = new CalculadoraPontuacaoBoliche();
	}

	@Test
	void deve_retornar_pontuacao_do_jogo_quando_todas_as_jogas_forem_zero() {
		int[] jogadas = {
				0, 0,
				0, 0,
				0, 0,
				0, 0,
				0, 0,
				0, 0,
				0, 0,
				0, 0,
				0, 0,
				0, 0,
		};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(0, pontuacaoDoJogo);
	}

	@Test
	void deve_retornar_a_pontuacao_do_jogo_quando_so_houver_jogadas_normal() {
		int[] jogadas = {
				1, 2,
				3, 4,
				1, 2,
				4, 0,
				5, 4,
				0, 0,
				2, 1,
				5, 1,
				6, 1,
				0, 8,
		};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(50, pontuacaoDoJogo);
	}

	@Test
	void deve_retornar_pontuacao_do_jogo_quando_houver_apenas_um_spare() {
		int[] jogadas = {
				1, 2,
				3, 4,
				1, 2,
				4, 0,
				5, 4,
				0, 0,
				2, 1,
				5, 1,
				1, 9,
				8, 0,
		};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(61, pontuacaoDoJogo);
	}

	@Test
	void deve_retornar_a_pontuacao_jogo_quando_houver_dois_spare_seguidos() {
		int[] jogadas = {
				1, 2,
				3, 4,
				1, 2,
				4, 0,
				5, 4,
				0, 0,
				2, 1,
				9, 1,
				9, 1,
				2, 5,
		};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(67, pontuacaoDoJogo);
	}

	@Test

	void deve_retornar_a_pontuacao_do_jogo_quando_houver_quando_houver_spare_no_final() {
		int[] jogadas = {
				1, 2,
				3, 4,
				1, 2,
				4, 0,
				5, 4,
				0, 0,
				2, 1,
				9, 1,
				9, 1,
				9, 1,
				10,
		};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(87, pontuacaoDoJogo);
	}

	@Test
	@DisplayName("deve retornar a pontuacao do jogo, quando houver um strike")
	void deve_retornar_pontuacao_do_jogo_quando_houver_um_strike() {
		int[] jogadas = {
				1, 2,
				3, 4,
				1, 2,
				4, 0,
				5, 4,
				0, 0,
				2, 1,
				10,
				8, 1,
				9, 0,
		};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(66, pontuacaoDoJogo);
	}

	@Test
	void deve_retornar_a_pontuacao_do_jogos_quando_houver_um_strike_no_final() {
		int[] jogadas = {
				1, 2,
				3, 4,
				1, 2,
				4, 0,
				5, 4,
				0, 0,
				2, 1,
				5, 1,
				8, 1,
				10,
				9,
				1,
		};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(64, pontuacaoDoJogo);
	}

	@Test
	void deve_retornar_a_pontuacao_do_jogos_quando_houver_um_strike_no_final_com_dois_strike_depois() {
		int[] jogadas = {
				1, 2,
				3, 4,
				1, 2,
				4, 0,
				5, 4,
				0, 0,
				2, 1,
				5, 1,
				8, 1,
				10,
				10,
				10,
		};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(74, pontuacaoDoJogo);
	}



	@Test
	@DisplayName("deve retornar a pontuacao do jogo, quando houver um spare no final, seguido de um strike")
	void deve_retornar_a_pontuacao_do_jogo_quando_houver_spare_no_final_seguido_de_um_strike() {
		int[] jogadas = {
				1, 2,
				3, 4,
				1, 2,
				4, 0,
				5, 4,
				0, 0,
				2, 1,
				5, 1,
				8, 1,
				9, 1,
				10,
		};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(64, pontuacaoDoJogo);
	}

	@Test
	void deve_retornar_a_pontuacao_do_jogos_quando_houver_um_spare_no_final_seguido_de_um_strike() {
		int[] jogadas = {
				1, 2,
				3, 4,
				1, 2,
				4, 0,
				5, 4,
				0, 0,
				2, 1,
				5, 1,
				8, 1,
				9, 1,
				5,
		};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(59, pontuacaoDoJogo);
	}


	@Test

	void deve_retornar_a_pontuacao_do_jogo_quando_houver_spare_strike() {
		int[] jogadas = {
				1, 4, // 9
				4, 5, // 14
				6, 4, // 29
				5, 5, // 49
				10,   // 60
				0, 1,
				7, 3,
				6, 4,
				10,
				2, 8,
				6};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(133, pontuacaoDoJogo);
	}


	@Test

	void deve_retornar_a_pontuacao_do_jogo_for_um_jogo_perfeito() {
		int[] jogadas = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

		var pontuacaoDoJogo = calculadora.pontuacaoDoJogo(jogadas);

		assertEquals(300, pontuacaoDoJogo);
	}


}
