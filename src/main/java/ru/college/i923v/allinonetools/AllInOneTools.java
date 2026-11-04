package ru.college.i923v.allinonetools;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllInOneTools implements ModInitializer {
	public static final String MOD_ID = "all-in-one-tools";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
				.register(entries -> entries.accept(ModItems.MULTITOOL));

		UseItemCallback.EVENT.register((player, world, hand) -> {
			ItemStack stack = player.getItemInHand(hand);

			// Чужие предметы пропускаем без изменений
			if (!stack.is(ModItems.MULTITOOL)) {
				return InteractionResultHolder.pass(stack);
			}

			// Сообщение отправляем только на серверной стороне, чтобы оно не повторялось
			if (!world.isClientSide()) {
				int left = stack.getMaxDamage() - stack.getDamageValue();
				player.displayClientMessage(
						Component.literal("Прочность мультитула: " + left + " из " + stack.getMaxDamage()),
						false
				);
			}

			return InteractionResultHolder.success(stack);
		});

		LOGGER.info("Проект загружен успешно");
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
