package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        manager.addCharacter(
                new Character("Arka", 10, CharacterType.WARRIOR));
        manager.addCharacter(
                new Character("Nara", 3, CharacterType.MAGE));
        manager.addCharacter(
                new Character("Bima", 7, CharacterType.ARCHER));
        manager.addCharacter(
                new Character("Sinta", 5, CharacterType.HEALER));
        manager.addCharacter(
                new Character("Raka", 2, CharacterType.WARRIOR));
        manager.addCharacter(
                new Character("Dina", 12, CharacterType.MAGE));

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
