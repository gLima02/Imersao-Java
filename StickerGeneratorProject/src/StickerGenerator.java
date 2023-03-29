

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class StickerGenerator {

	public void criar(InputStream inputStream, String nomeArquivo) throws Exception {
		//leitura
		 // leitura da imagem
        // InputStream inputStream = 
        //             new FileInputStream(new File("entrada/filme-maior.jpg"));
        // InputStream inputStream = 
        //                 new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
        //                 .openStream();
        BufferedImage imgOriginal = ImageIO.read(inputStream);
		
		//nova imagem em memória (transparencia e tamanho novo)
		
		int largura = imgOriginal.getWidth();
		int altura = imgOriginal.getHeight();
		int novaAltura = altura + 200;
		
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
				
		//copiar a imagem original para a nova imagem (em memoria) 
		
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imgOriginal, 0, 0, null);
		
		//fonte
		
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
		
		//escrever uma frase na nova imagem
		graphics.drawString("texto teste", 150, novaAltura -100);

		//escrever a nova imagem em um arquivo
										//endereco nova imagem pc
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
		
	}
	
}
