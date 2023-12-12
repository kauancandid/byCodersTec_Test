package com.ByCodersTec;

import com.ByCodersTec.controller.TransacaoController;
import com.ByCodersTec.service.TransacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@SpringBootTest
class ByCodersTecApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	private TransacaoController transacaoController;

	@Mock
	private TransacaoService transacaoService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testUploadArquivoComSucesso() throws Exception {
		MultipartFile file = new MockMultipartFile("file", "teste.txt", "text/plain", "3201903010000014200096206760174753****3153153453JOÃO MACEDO   BAR DO JOÃO ".getBytes());

		ResponseEntity<String> response = transacaoController.uploadArquivo(file);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Arquivo enviado e processado com sucesso.", response.getBody());
		verify(transacaoService, times(1)).salvarTransacoes(anyList());
	}

	@Test
	public void testUploadArquivoArquivoVazio() throws Exception {
		MultipartFile file = new MockMultipartFile("file", "empty.txt", "text/plain", new byte[0]);

		ResponseEntity<String> response = transacaoController.uploadArquivo(file);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("O arquivo está vazio.", response.getBody());
		verify(transacaoService, never()).salvarTransacoes(anyList());
	}

}
