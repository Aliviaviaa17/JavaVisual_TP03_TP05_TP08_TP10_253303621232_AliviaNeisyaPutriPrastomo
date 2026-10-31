package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    // Konstanta batas level untuk Mini-Challenge
    private static final int HIGH_LEVEL_THRESHOLD = 5;

    private final CharacterManager manager;
    private final JPanel characterList;
    private final JLabel averageLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - TP10 v0.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBackground(AppTheme.BACKGROUND);
        root.setOpaque(true);
        root.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

        JLabel title = new JLabel("Character Manager");
        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.PRIMARY);

        characterList = new JPanel();
        characterList.setLayout(
                new BoxLayout(characterList, BoxLayout.Y_AXIS));
        characterList.setBackground(AppTheme.BACKGROUND);
        characterList.setOpaque(true);

        JScrollPane scrollPane = new JScrollPane(characterList);
        scrollPane.setPreferredSize(new Dimension(480, 380));
        scrollPane.setBorder(AppTheme.CARD_BORDER);
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);
        scrollPane.getViewport().setOpaque(true);

        averageLabel = new JLabel();
        averageLabel.setFont(AppTheme.EMPHASIS_FONT);
        averageLabel.setForeground(AppTheme.PRIMARY);
        averageLabel.setBorder(
                BorderFactory.createEmptyBorder(12, 0, 0, 0));

        root.add(title, BorderLayout.NORTH);
        root.add(scrollPane, BorderLayout.CENTER);
        root.add(averageLabel, BorderLayout.SOUTH);

        setContentPane(root);
        refreshCharacters();

        pack();
        setLocationRelativeTo(null);
    }

    public final void refreshCharacters() {
        characterList.removeAll();

        List<Character> characters = manager.getAllCharacters();

        for (Character character : characters) {
            JPanel card = createCharacterCard(character);

            card.setAlignmentX(Component.LEFT_ALIGNMENT);
            characterList.add(card);
            characterList.add(Box.createVerticalStrut(10));
        }

        double average = manager.getAverageLevel();
        averageLabel.setText(
                String.format("Rata-rata Level: %.2f", average));

        characterList.revalidate();
        characterList.repaint();
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createCharacterCard(Character character) {
        JPanel card = new JPanel(new BorderLayout(12, 4));
        card.setOpaque(true);
        card.setBackground(AppTheme.colorFor(character.getType()));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        borderColorFor(character.getType()), 2),
                AppTheme.CARD_BORDER));

        JLabel nameLabel = new JLabel(character.getName());
        nameLabel.setFont(AppTheme.BODY_FONT);
        nameLabel.setForeground(AppTheme.TEXT);

        JLabel detailLabel = new JLabel(
                "Level: " + character.getLevel()
                        + " | Role: " + character.getType());
        detailLabel.setFont(AppTheme.DETAIL_FONT);
        detailLabel.setForeground(AppTheme.MUTED);

        if (character.getLevel() >= HIGH_LEVEL_THRESHOLD) {
            nameLabel.setForeground(AppTheme.GOLD);
            nameLabel.setFont(AppTheme.EMPHASIS_FONT);
        }

        card.add(nameLabel, BorderLayout.NORTH);
        card.add(detailLabel, BorderLayout.CENTER);

        // Properti tambahan 1: tooltip detail karakter
        card.setToolTipText(
                "Nama: " + character.getName()
                        + " | Level: " + character.getLevel()
                        + " | Role: " + character.getType());

        // Properti tambahan 2: border berbeda berdasarkan role
        card.setAlignmentX(Component.LEFT_ALIGNMENT);

        return card;
    }

    private Color borderColorFor(CharacterType type) {
        if (type == null) {
            return AppTheme.MUTED;
        }

        switch (type) {
            case WARRIOR:
                return AppTheme.PRIMARY;
            case MAGE:
                return AppTheme.GOLD;
            case ARCHER:
                return AppTheme.MUTED;
            case HEALER:
                return AppTheme.GOLD;
            default:
                return AppTheme.MUTED;
        }
    }
}
