package club.mytree;

import java.util.List;
import java.util.TimerTask;

/**
 * Created by vsevo on 05.05.17.
 * test version
 */
public class UpdateDBOnTimer extends TimerTask {



    @Override
    public void run() {
        VkClient vk = new VkClient();
        String idis = vk.getUsersInGroup(Main.GROUP_NAME);
        System.out.println(idis);
        int users[] = VkClient.parseUsersInGroup(idis);
        String online = vk.isUsersOnline(users);
        //System.out.println(online);
        List<UserOnline> uo = VkClient.parseOnlineUsers(online);

        SQLiteConnection sql = new SQLiteConnection(Main.GROUP_NAME,false);
        sql.update(uo);
    }
}
