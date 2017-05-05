package club.mytree;

/**
 * Created by vsevo on 03.05.17.
 * test version
 */
class UserOnline {
    public int id;
    public int online;
    public int time;

    UserOnline() {
        this.id = 0;
        this.online = 0;
        this.time = 0;
    }

    UserOnline(int id, int online, int time) {
        this.id = id;
        this.online = online;
        this.time = time;
    }

    UserOnline(int id, int online) {
        this.id = id;
        this.online = online;
        this.time = 0;
    }
}
