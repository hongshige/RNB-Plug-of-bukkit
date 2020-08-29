package rnb;
// 包名

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.TabCompleter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
// 导入的包
/**
 * @author redstonebread
 */

public final class Rb extends JavaPlugin implements Listener  {
    private JavaPlugin plugin = null;
    private static final String COMMAND_NAME = "rnb";
    private String[] rnpCommands = {"a", "c", "about","math"};
    // 自动补全列表
    String x="0" , z = "0";
    double nx = new Double(x);
    double nz = new Double(z);
    int am = 0;
    int ap = 0;
    int bm = 1;
    int bp = 1;
    // 插件使用的值[(重要勿动)(改名可能会导致报错，请自行修改)]
    @Override
    public void onEnable() {
        // 插件启动事件
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        // 获取配置文件
        getLogger().info("                              \n " +
                "#   /—-------/   /-------/   |-------|\n "+
                "#   /       /    /       /   |       |\n" +
                "#   /-------     /       /   |--------\n" +
                "#  / \\          /       /   |       \\\n" +
                "# /    \\        /       /   |       |\n" +
                "#/       \\      /       /   |-------");
        getLogger().info("当前插件版本:"+config.getString("ver"));
        // 插件开启提示
        getCommand(COMMAND_NAME).setExecutor(this);
        getCommand(COMMAND_NAME).setTabCompleter(this);
        Bukkit.getPluginCommand("rnb").setExecutor(this);
        config.set("#NAME", "Restad");
        saveConfig();
        // 配置管理
    }
    @EventHandler
    public void onx(AsyncPlayerChatEvent event) {
        if (am == 1) {
            x = event.getMessage();
            ;
        }
    }

    @EventHandler
    public void onz(AsyncPlayerChatEvent event) {
        if(ap == 1){
            z = event.getMessage();
        }
    }
        // 获取聊天消息


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.getPluginManager().registerEvents(this, this);
        if (command.getName().equalsIgnoreCase("rnb")) {
            if (args.length == 0) {
            } else {
                if (args[0].toLowerCase().equals("c")) {
                    if (!(sender instanceof Player)) {
                        sender.sendMessage("[RNB]错误:只有玩家才能使用该命令");
                        return true;
                    }
                    // 玩家判定器
                    sender.sendMessage("[RNB]换算功能开始运行");
                    sender.sendMessage("[RNB][WARN]请不要输入字母和小数");
                    sender.sendMessage("[RNB][WARN]请输入半角负号");
                    sender.sendMessage("请输入数值A");
                        am=bm;
                        // 未完成
                        // 预计功能：获取玩家消息后赋值x后执行下一条代码(需正则表达式判断）
                        nx=Double.parseDouble(x);
                    sender.sendMessage("请输入数值B");
                        ap=bp;
                        // 未完成
                        // 预计功能：获取玩家消息后赋值x后执行下一条代码(需正则表达式判断）
                        nz=Double.parseDouble(z);
                    sender.sendMessage("[RNB]计算中...");
                        try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                    // 此代码运行缓慢，好让玩家给钱优化插件
                     int wx = (int) (((nx)) / 8);
                     int wz = (int) (((nz)) / 8);
                     int ax = (int) (((nx)) * 8);
                     int az = (int) (((nz)) * 8);
                     // 简易的计算
                     sender.sendMessage("[RNB]地狱→主世界");
                     sender.sendMessage("X" + wx);
                     sender.sendMessage("Z" + wz);
                     sender.sendMessage("[RNB]主世界→地狱");
                     sender.sendMessage("X" + ax);
                     sender.sendMessage("Z" + az);
                     // 输出值
                        return true;

                }
                if (args[0].toLowerCase().equals("about")) {
                    sender.sendMessage("---RNB ABOUT---");
                    sender.sendMessage("本插件仅供RCPIO内部使用");
                    sender.sendMessage("禁 止 外 流");
                    sender.sendMessage("RedstoneBread©2020 版权所有");
                    // 禁止删除声明信息 删除必究!
                    return true;
                }

                if (args[0].toLowerCase().equals("a")) {
                    sender.sendMessage("--RNB AUTO--");
                    sender.sendMessage("自动开始转换当前坐标");
                    sender.sendMessage("目前不可用");
                    // 还没做呢 U•ェ•*U
                    return true;
                }
                if (args[0].toLowerCase().equals("math")) {
                    sender.sendMessage("--RCPIO数学即时计算程序--");
                    sender.sendMessage("--不可用--");
                    sender.sendMessage("功能目前未实现");
                    sender.sendMessage("敬请期待RNBM");
                    // 咕咕咕 (⓿_⓿)
                    return true;
                }

            }

        }
        sender.sendMessage("----RNB(B版)帮助----");
        sender.sendMessage("帮助 /rnb");
        sender.sendMessage("自动获得当前世界坐标换算 /rnb a");
        sender.sendMessage("手动输入坐标换算:");
        sender.sendMessage("/rnb c");
        sender.sendMessage("关于插件:");
        sender.sendMessage("/rnb about");
        sender.sendMessage("(1/1)页");
        // 代码默认执行这块内容

        return true;


    }
    //插件命令执行代码
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        //如果不是能够补全的长度，则返回空列表
        if (args.length > 1) {
            return new ArrayList<>();
        }

        //如果此时仅输入了命令"rnp"，则直接返回所有的子命令
        if (args.length == 0) {
            return Arrays.asList(rnpCommands);
        }

        //筛选所有可能的补全列表，并返回
        return Arrays.stream(rnpCommands).filter(s -> s.startsWith(args[0])).collect(Collectors.toList());
    }

    @Override
    public void onDisable() {
        // 插件重启、关闭时提示
        System.out.println("[RNB]插件已停用");
    }
}
