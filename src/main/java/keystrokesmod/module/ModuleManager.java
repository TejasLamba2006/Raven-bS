package keystrokesmod.module;

import keystrokesmod.clickgui.components.impl.ModuleComponent;
import keystrokesmod.module.impl.client.Settings;
import keystrokesmod.utility.Utils;
import keystrokesmod.module.impl.client.CommandLine;
import keystrokesmod.module.impl.client.Gui;
import keystrokesmod.module.impl.combat.*;
import keystrokesmod.module.impl.fun.Fun;
import keystrokesmod.module.impl.minigames.BridgeInfo;
import keystrokesmod.module.impl.minigames.DuelsStats;
import keystrokesmod.module.impl.minigames.MurderMystery;
import keystrokesmod.module.impl.minigames.SumoFences;
import keystrokesmod.module.impl.movement.*;
import keystrokesmod.module.impl.other.FakeChat;
import keystrokesmod.module.impl.other.NameHider;
import keystrokesmod.module.impl.player.WaterBucket;
import keystrokesmod.module.impl.player.*;
import keystrokesmod.module.impl.render.*;
import keystrokesmod.module.impl.world.AntiBot;
import keystrokesmod.utility.profile.Manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ModuleManager {
   static List<Module> modules = new ArrayList<>();
   public static List<Module> organizedModules = new ArrayList<>();
   public static Module nameHider;
   public static Module fastPlace;
   public static Module antiShuffle;
   public static Module commandLine;
   public static Module antiBot;
   public static Module noSlow;
   public static Module killAura;
   public static Module autoClicker;
   public static Module hitBox;
   public static Module reach;
   public static Module hud;
   public static Module timer;
   public static Module fly;
   public static Module noFall;
   public static Module playerESP;
   public static Module safeWalk;
   public static Module keepSprint;

   public void register() {
      this.addModule(autoClicker = new AutoClicker());
      this.addModule(new AimAssist());
      this.addModule(new BurstClicker());
      this.addModule(new ClickAssist());
      this.addModule(new DelayRemover());
      this.addModule(hitBox = new HitBox());
      this.addModule(new Settings());
      this.addModule(reach = new Reach());
      this.addModule(new RodAimbot());
      this.addModule(new Velocity());
      this.addModule(new BHop());
      this.addModule(new Boost());
      this.addModule(fly = new Fly());
      this.addModule(new InvMove());
      this.addModule(keepSprint = new KeepSprint());
      this.addModule(noSlow = new NoSlow());
      this.addModule(new Speed());
      this.addModule(new Sprint());
      this.addModule(new StopMotion());
      this.addModule(timer = new Timer());
      this.addModule(new VClip());
      this.addModule(new AutoJump());
      this.addModule(new AutoPlace());
      this.addModule(new BedAura());
      this.addModule(fastPlace = new FastPlace());
      this.addModule(new Freecam());
      this.addModule(noFall = new NoFall());
      this.addModule(safeWalk = new SafeWalk());
      this.addModule(antiBot = new AntiBot());
      this.addModule(antiShuffle = new AntiShuffle());
      this.addModule(new Chams());
      this.addModule(new ChestESP());
      this.addModule(new Nametags());
      this.addModule(playerESP = new PlayerESP());
      this.addModule(new Tracers());
      this.addModule(hud = new HUD());
      this.addModule(new Xray());
      this.addModule(new BridgeInfo());
      this.addModule(new TargetHUD());
      this.addModule(new DuelsStats());
      this.addModule(new MurderMystery());
      this.addModule(new SumoFences());
      this.addModule(new Fun.ExtraBobbing());
      this.addModule(killAura = new KillAura());
      this.addModule(new Fun.FlameTrail());
      this.addModule(new Fun.SlyPort());
      this.addModule(new ItemESP());
      this.addModule(new MobESP());
      this.addModule(new Fun.Spin());
      this.addModule(new FakeChat());
      this.addModule(nameHider = new NameHider());
      this.addModule(new WaterBucket());
      this.addModule(commandLine = new CommandLine());
      this.addModule(new Manager());
      this.addModule(new Gui());
      antiBot.enable();
      Collections.sort(this.modules, Comparator.comparing(Module::getName));
   }

   public void addModule(Module m) {
      modules.add(m);
   }

   public List<Module> getModules() {
      return modules;
   }

   public List<Module> inCategory(Module.category categ) {
      ArrayList<Module> categML = new ArrayList<>();

      for (Module mod : this.getModules()) {
         if (mod.moduleCategory().equals(categ)) {
            categML.add(mod);
         }
      }

      return categML;
   }

   public Module getModule(String moduleName) {
      for (Module module : modules) {
         if (module.getName().equals(moduleName)) {
            return module;
         }
      }
      return null;
   }

   public static void sort() {
      if (HUD.alphabeticalSort.isToggled()) {
         Collections.sort(organizedModules, Comparator.comparing(Module::getName));
      } else {
         Collections.sort(organizedModules, (o1, o2) -> Utils.mc.fontRendererObj.getStringWidth(o2.getName() + (HUD.showInfo.isToggled() ? " " + o2.getInfo() : "")) - Utils.mc.fontRendererObj.getStringWidth(o1.getName() + (HUD.showInfo.isToggled() ? " " + o2.getInfo() : "")));
      }
   }
}