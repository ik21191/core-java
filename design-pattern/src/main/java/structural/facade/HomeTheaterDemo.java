package structural.facade;

// Subsystem components
class TV {
  public void turnOn() {
    System.out.println("TV is on");
  }

  public void setInput(String input) {
    System.out.println("TV input set to: " + input);
  }

  public void turnOff() {
    System.out.println("TV is off");
  }
}

class DVDPlayer {
  public void turnOn() {
    System.out.println("DVD Player is on");
  }

  public void play(String movie) {
    System.out.println("Playing movie: " + movie);
  }

  public void turnOff() {
    System.out.println("DVD Player is off");
  }
}


class SurroundSoundSystem {
  public void turnOn() {
    System.out.println("Surround Sound System is on");
  }

  public void setVolume(int volume) {
    System.out.println("Surround Sound volume set to: " + volume);
  }

  public void turnOff() {
    System.out.println("Surround Sound System is off");
  }
}

// Facade class
class HomeTheaterFacade {
  private TV tv;
  private DVDPlayer dvdPlayer;
  private SurroundSoundSystem soundSystem;

  public HomeTheaterFacade(TV tv, DVDPlayer dvdPlayer, SurroundSoundSystem soundSystem) {
    this.tv = tv;
    this.dvdPlayer = dvdPlayer;
    this.soundSystem = soundSystem;
  }

  public void watchMovie(String movie) {
    System.out.println("Getting ready to watch a movie...");
    tv.turnOn();
    tv.setInput("DVD");
    dvdPlayer.turnOn();
    soundSystem.turnOn();
    soundSystem.setVolume(10);
    dvdPlayer.play(movie);
  }

  public void endMovie() {
    System.out.println("Shutting down home theater...");
    dvdPlayer.turnOff();
    soundSystem.turnOff();
    tv.turnOff();
  }
}

// Client code
public class HomeTheaterDemo {
  public static void main(String[] args) {
    TV tv = new TV();
    DVDPlayer dvdPlayer = new DVDPlayer();
    SurroundSoundSystem soundSystem = new SurroundSoundSystem();

    HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, dvdPlayer, soundSystem);

    homeTheater.watchMovie("The Matrix");
    System.out.println("\nMovie finished.\n");
    homeTheater.endMovie();
  }
}
