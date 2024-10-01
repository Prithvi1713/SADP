public class AudioPlayerApp {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("mp3", "song.mp3");
        player.play("mp4", "video.mp4");
        player.play("vlc", "movie.vlc");
        player.play("wav", "audio.wav");  // Invalid type example
    }
}

class AudioPlayer {
    private MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
            mediaAdapter = new MediaAdapter(audioType);
            if (audioType.equalsIgnoreCase("mp4")) {
                mediaAdapter.playMp4(fileName);
            } else {
                mediaAdapter.playVlc(fileName);
            }
        } else {
            System.out.println("Invalid audio type: " + audioType + ".");
        }
    }
}

interface AdvancedMediaPlayer {
    void playMp4(String fileName);
    void playVlc(String fileName);
}

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file. Name: " + fileName);
    }

    @Override
    public void playVlc(String fileName) {
        // Do nothing
    }
}

class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        // Do nothing
    }

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file. Name: " + fileName);
    }
}

class MediaAdapter implements AdvancedMediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        } else if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        }
    }

    @Override
    public void playMp4(String fileName) {
        if (advancedMediaPlayer != null) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }

    @Override
    public void playVlc(String fileName) {
        if (advancedMediaPlayer != null) {
            advancedMediaPlayer.playVlc(fileName);
        }
    }
}

