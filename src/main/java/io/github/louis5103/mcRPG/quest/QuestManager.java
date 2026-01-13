package io.github.louis5103.mcRPG.quest;


import org.bukkit.Material;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class QuestManager {
    private Map<UUID, Queue<Material>> buffer = new ConcurrentHashMap<>();
    private static final QuestManager instance = new QuestManager();

    private QuestManager(){}
    public static QuestManager getInstance(){
        return instance;
    }

    public void addNewQuestUser(UUID uuid){
        if (!isExistUserInQuest(uuid))
            buffer.put(uuid, new LinkedList<>(List.of(Material.GRASS_BLOCK, Material.DIRT, Material.OAK_WOOD)));
    }

    public void removeQuestUser(UUID uuid){
        if (!isExistUserInQuest(uuid))
            throw new RuntimeException("QuestManager에서 퀘스트 진행중인 유저를 찾을 수 없습니다.");
        buffer.remove(uuid);
    }

    public void updateQuestProgress(UUID uuid){
        if (!isExistUserInQuest(uuid))
            throw new RuntimeException("QuestManager에서 퀘스트 진행중인 유저를 찾을 수 없습니다.");
        buffer.get(uuid).poll();
    }
    public Optional<Material> checkAndUpdateQuest(UUID uuid, Material material){
        Queue<Material> data = buffer.get(uuid);
        return data.peek() == material ? Optional.of(data.poll()) : Optional.empty();
    }

    private boolean isExistUserInQuest(UUID uuid){
        if(buffer.containsKey(uuid)) return true;
        return false;
    }

    public void validAndCreateQuestUser(UUID uuid){
        if(isExistUserInQuest(uuid)) return;
        addNewQuestUser(uuid);
    }
}
