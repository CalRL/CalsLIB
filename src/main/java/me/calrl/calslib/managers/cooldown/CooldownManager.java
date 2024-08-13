package me.calrl.calslib.managers.cooldown;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.UUID;

public class CooldownManager {

    private final Table<String, CooldownType, Long> cooldowns = HashBasedTable.create();

    public long getCooldown(UUID uuid, CooldownType type) {
        return calculateRemainder(cooldowns.get(uuid.toString(), type));
    }

    public long setCooldown(UUID uuid, CooldownType type, Long time) {
        return calculateRemainder(cooldowns.put(uuid.toString(), type, System.currentTimeMillis() + (time * 1000)));
    }

    public boolean tryCooldown(UUID uuid, CooldownType key, long delay) {
        if (getCooldown(uuid, key) / 1000 > 0) return false;
        setCooldown(uuid, key, delay + 1);
        return true;
    }

    private long calculateRemainder(Long expireTime) {
        return expireTime != null ? expireTime - System.currentTimeMillis() : Long.MIN_VALUE;
    }

}
