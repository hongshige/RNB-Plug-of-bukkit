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

public final class Rb extends JavaPlugin implements Listener {
    private JavaPlugin plugin = null;
    private static final String COMMAND_NAME = "rnb";
    private String[] rnpCommands = {"a", "c", "about", "math", "help"};
    // 自动补全列表
    String x = "0", z = "0";
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
        getLogger().info("RNB多功能实用插件");
        getLogger().info("当前插件版本:" + config.getString("ver"));
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
        if (ap == 1) {
            z = event.getMessage();
        }
    }
    // 获取聊天消息


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.getPluginManager().registerEvents(this, this);
        FileConfiguration config = getConfig();
        String ver = config.getString("ver");

        if (ver == "1.0") {
            if (command.getName().equalsIgnoreCase("rnb")) {
                if (args.length == 0) {
                } else {
                    if (args[0].toLowerCase().equals("c")) {
                        if (!(sender instanceof Player)) {
                            sender.sendMessage("[RNB]错误:只有玩家才能使用该命令");
                            return true;
                        }
                        // 判定器
                        sender.sendMessage("[RNB]换算功能开始运行");
                        sender.sendMessage("[RNB][WARN]请不要输入字母和小数");
                        sender.sendMessage("[RNB][WARN]请输入半角负号");
                        sender.sendMessage("请输入数值A");
                        am = bm;
                        // 未完成
                        // TODO [主功能]预计功能：获取玩家消息后赋值x后执行下一条代码(需正则表达式判断）
                        nx = Double.parseDouble(x);
                        sender.sendMessage("请输入数值B");
                        ap = bp;
                        // 未完成
                        // TODO [主功能]预计功能：获取玩家消息后赋值x后执行下一条代码(需正则表达式判断）
                        nz = Double.parseDouble(z);
                        sender.sendMessage("[RNB]计算中...");
                        int wx = (int) (((nx)) / 8);
                        int wz = (int) (((nz)) / 8);
                        int ax = (int) (((nx)) * 8);
                        int az = (int) (((nz)) * 8);
                        // 计算区域
                        sender.sendMessage("[RNB]地狱→主世界");
                        sender.sendMessage("X" + wx);
                        sender.sendMessage("Z" + wz);
                        sender.sendMessage("[RNB]主世界→地狱");
                        sender.sendMessage("X" + ax);
                        sender.sendMessage("Z" + az);
                        // 返回值
                        return true;
                        //重要 无此行代码 插件无法运行

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
                        // TODO [自动坐标转换]还没做呢 U•ェ•U
                        /**
                         * 实现方法:
                         * 利用bukkit api获取玩家当前坐标
                         * 忽略y坐标值 并计算xz坐标值
                         * *8 /8 后返回坐标值
                         * 则该功能结束
                         * #难点 获取玩家名 忽略y
                         **/
                        return true;
                    }
                    if (args[0].toLowerCase().equals("math")) {
                        sender.sendMessage("--RCPIO数学即时计算程序--");
                        sender.sendMessage("--不可用--");
                        sender.sendMessage("功能目前未实现");
                        sender.sendMessage("敬请期待RNBM");
                        // TODO 咕咕咕 (⓿_⓿)
                        /**
                         * 该功能不打算在本插件内实现
                         * 预计制作一附属
                         * #难点: 依赖库的实现 复杂数学计算的判断 表达式可行性判断
                         * 可移植性代码
                         **/
                        return true;
                    }
                    if (args[0].toLowerCase().equals("help")) {
                        sender.sendMessage("----RNB(B版)帮助----");
                        sender.sendMessage("主命令   /rnb");
                        sender.sendMessage("自动计算 /rnb a");
                        sender.sendMessage("手动计算 /rnb c");
                        sender.sendMessage("关于    /rnb about");
                        int math = 0;
                        //此处重设math值
                        if (math == 1) {
                            sender.sendMessage("MATH /rnb math");
                        }
                        sender.sendMessage("(1/1)页");
                        return true;
                        //帮助 (90%已完成) (待制作功能-可移植性)
                    }

                }

            }

            // 代码默认执行这块内容
            sender.sendMessage("输入/rnb help 来获取帮助");
            return true;


        }
        sender.sendMessage("[反编辑:ERROR]请勿擅自修改版本号");
        System.out.println("[VER_LOCK:ERROR]请勿擅自修改版本号");
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
