package music;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class gcAudioPlayer {
	
   public  SourceDataLine sdl = null;

   
   
   public void playMusic(String a) {
		
		try {
			File file = new File ("music/bgm"+a+".wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			AudioFormat af = ais.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
			sdl = (SourceDataLine) AudioSystem.getLine(info);
			sdl.open(af);
			sdl.start();
			int nByte = 0;
			byte[] buffer = new byte[128];
			while (nByte != -1) {
				nByte = ais.read(buffer, 0, 128);
				if (nByte >= 0) {
					sdl.write(buffer, 0, nByte);
				}
		    }
			
			
		} catch (Exception e) {}
		
	
}	
   public  void stopMusic(){
	       sdl = null;
}
}
