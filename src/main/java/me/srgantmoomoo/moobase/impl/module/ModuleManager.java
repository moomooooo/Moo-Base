package me.srgantmoomoo.moobase.impl.module;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

<<<<<<< HEAD
import me.srgantmoomoo.moobase.api.utils.RenderUtil;
=======
<<<<<<< HEAD
import me.srgantmoomoo.moobase.api.utils.RenderUtil;
import me.srgantmoomoo.moobase.impl.Main;
=======
>>>>>>> 1a654f13a40060476cc863e939918f10aa5112b8
>>>>>>> b012fe16277218f245557080ac1af46d9ef1da3c
import me.srgantmoomoo.moobase.impl.module.modules.movement.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class ModuleManager {
	public static ArrayList<Module> modules;
	
	public ModuleManager() {
		modules = new ArrayList<>();
		
		// Player
		
		// Render
		
		// Combat
		
		// Exploits
		
		// Movement
		modules.add(new Sprint());
		
		// Client
		
	}
	
	public static void onUpdate() {
		modules.stream().filter(Module::isToggled).forEach(Module::onUpdate);
	}
	
	public static void onRender() {
		modules.stream().filter(Module::isToggled).forEach(Module::onRender);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
		Main.getInstance().clickGui.render();
>>>>>>> 1a654f13a40060476cc863e939918f10aa5112b8
>>>>>>> b012fe16277218f245557080ac1af46d9ef1da3c
	}
	
	public static void onWorldRender(RenderWorldLastEvent event) {
		Minecraft.getMinecraft().mcProfiler.startSection("postman");
		Minecraft.getMinecraft().mcProfiler.startSection("setup");
<<<<<<< HEAD
		RenderUtil.prepare();
=======
<<<<<<< HEAD
		RenderUtil.prepare();
		//RenderEvent e = new RenderEvent(event.getPartialTicks());
=======
		JTessellator.prepare();
		RenderEvent e = new RenderEvent(event.getPartialTicks());
>>>>>>> 1a654f13a40060476cc863e939918f10aa5112b8
>>>>>>> b012fe16277218f245557080ac1af46d9ef1da3c
		Minecraft.getMinecraft().mcProfiler.endSection();

		modules.stream().filter(module -> module.isToggled()).forEach(module -> {
			Minecraft.getMinecraft().mcProfiler.startSection(module.getName());
<<<<<<< HEAD
			//module.onWorldRender(e);
=======
<<<<<<< HEAD
			//module.onWorldRender(e);
=======
			module.onWorldRender(e);
>>>>>>> 1a654f13a40060476cc863e939918f10aa5112b8
>>>>>>> b012fe16277218f245557080ac1af46d9ef1da3c
			Minecraft.getMinecraft().mcProfiler.endSection();
		});

		Minecraft.getMinecraft().mcProfiler.startSection("release");
<<<<<<< HEAD
		RenderUtil.release();
=======
<<<<<<< HEAD
		RenderUtil.release();
=======
		JTessellator.release();
>>>>>>> 1a654f13a40060476cc863e939918f10aa5112b8
>>>>>>> b012fe16277218f245557080ac1af46d9ef1da3c
		Minecraft.getMinecraft().mcProfiler.endSection();
		Minecraft.getMinecraft().mcProfiler.endSection();
	}
	
	public static boolean isModuleEnabled(String name){
		Module m = modules.stream().filter(mm->mm.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
		return m.isToggled();
	}
	
	public Module getModule (String name) {
		for (Module m : ModuleManager.modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public static ArrayList<Module> getModuleList() {
		return ModuleManager.modules;
	}
	
	public static ArrayList<Module> getModulesInCategory(Category c){
		ArrayList<Module> list = (ArrayList<Module>) getModuleList().stream().filter(m -> m.getCategory().equals(c)).collect(Collectors.toList());
		return list;
	}
	
	public static Module getModuleByName(String name) {
		Module m = modules.stream().filter(mm->mm.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
		return m;
	}
	
	@SubscribeEvent
	public void key(KeyInputEvent e) {
		if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
			return;
		try {
			if(Keyboard.isCreated()) {
				if(Keyboard.getEventKeyState()) {
					int keyCode = Keyboard.getEventKey();
					if(keyCode <= 0)
						return;
					for(Module m : ModuleManager.modules) {
						if(m.getKey() == keyCode && keyCode > 0) {
							m.toggle();
						}
					}
				}
			}
		} catch (Exception q) { q.printStackTrace(); }
	}

}
