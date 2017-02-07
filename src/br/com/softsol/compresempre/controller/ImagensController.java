package br.com.softsol.compresempre.controller;

import java.io.File;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.softsol.compresempre.imagens.Imagens;
import br.com.softsol.compresempre.modelo.Subgrupo;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class ImagensController {
	private final Imagens imagens;
	private final Result result;

	public ImagensController(Imagens imagens, Result result) {
		this.imagens = imagens;
		this.result = result;
	}

	@Post("/subgrupo/{subgrupo.id}/imagem")
	public void upload(Subgrupo subgrupo, final UploadedFile imagem) {
		imagens.salva(imagem, subgrupo);
		result.redirectTo(SubgrupoController.class).edita(subgrupo.getId());
	}

	@Get("/subgrupo/{subgrupo.id}/imagem")
	public File download(Subgrupo subgrupo) {
		return imagens.mostra(subgrupo);
	}

}
