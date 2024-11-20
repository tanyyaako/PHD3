package com.example.demo.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomMapper {
    public static List<String> stringToList(String participants) {
        if (participants != null && !participants.isEmpty()) {
            return Arrays.stream(participants.split(",\\s*"))  // Разделяем строку по запятой и пробелу
                    .collect(Collectors.toList());
        }
        return null;
    }

    // Преобразование списка строк в строку
    public static String listToString(List<String> participantsList) {
        if (participantsList != null && !participantsList.isEmpty()) {
            return String.join(", ", participantsList);  // Объединяем список в строку через запятую
        }
        return "";
    }
}
