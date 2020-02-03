public class MusicPlayer {
    private Music music;
    private int volume;

    public void init() {
        System.out.println("call init method");
    }

    public void destroy() {
        System.out.println("call destroy method");
    }


    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
