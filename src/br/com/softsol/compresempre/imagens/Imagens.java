package br.com.softsol.compresempre.imagens;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Subgrupo;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class Imagens {
	private File pastaImagens;

	public Imagens() {
		String pastaImagens = "/usr/local/apache-tomcat-7.0/chroot/csempre/webapp/fotos";
		//String pastaImagens = "/usr/local/apache-tomcat-7.0/chroot/csempre/webapp/compresempre/foto";
		this.pastaImagens = new File(pastaImagens);
		File destino = new File(pastaImagens);
		destino.mkdir();
	}

	public void salva(UploadedFile imagem, Subgrupo subgrupo) {
		File destino = new File(pastaImagens, subgrupo.getId() + ".imagem");
		try {
			IOUtils.copy(imagem.getFile(), new FileOutputStream(destino));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao copiar imagem", e);
		}
	}

	public File mostra(Subgrupo subgrupo) {
		return new File(pastaImagens, subgrupo.getId() + ".imagem");
	}

}
