package GUI;

import BuilderFactory.DolGuldurOrkBuilderFactory;
import BuilderFactory.MistyMountainsOrkBuilderFactory;
import BuilderFactory.MordorOrkBuilderFactory;
import BuilderFactory.OrkBuilderFactory;
import BuilderFactory.OrcDirector;
import Model.Ork;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class OrcArmyApp extends JFrame {
    private JComboBox<String> tribeComboBox;
    private JComboBox<String> roleComboBox;
    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel treeModel;
    private JTree armyTree;
    private JPanel orkInfoPanel;

    private final Map<DefaultMutableTreeNode, Ork> orkMap = new HashMap<>();

    public OrcArmyApp() {
        super("Орочья армия");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        initUI();
    }

    private void initUI() {
        JPanel controlPanel = new JPanel();
        tribeComboBox = new JComboBox<>(new String[]{"Мордор", "Дол Гулдур", "Мглистые Горы"});
        roleComboBox = new JComboBox<>(new String[]{"Рядовой", "Командир", "Разведчик"});
        JButton createOrkButton = new JButton("Создать орка");

        controlPanel.add(new JLabel("Племя:"));
        controlPanel.add(tribeComboBox);
        controlPanel.add(new JLabel("Роль:"));
        controlPanel.add(roleComboBox);
        controlPanel.add(createOrkButton);

        add(controlPanel, BorderLayout.NORTH);

        rootNode = new DefaultMutableTreeNode("Армия Мордора");
        treeModel = new DefaultTreeModel(rootNode);
        armyTree = new JTree(treeModel);
        JScrollPane treeScrollPane = new JScrollPane(armyTree);
        add(treeScrollPane, BorderLayout.WEST);

        orkInfoPanel = new JPanel();
        orkInfoPanel.setLayout(new BoxLayout(orkInfoPanel, BoxLayout.Y_AXIS));
        orkInfoPanel.setBorder(BorderFactory.createTitledBorder("Информация об орке"));
        add(orkInfoPanel, BorderLayout.CENTER);

        createOrkButton.addActionListener(_ -> createOrk());
        armyTree.addTreeSelectionListener(_ -> showOrkInfo());
    }

    private void createOrk() {
        String tribe = (String) tribeComboBox.getSelectedItem();
        String role = (String) roleComboBox.getSelectedItem();
        OrkBuilderFactory factory;

        switch (tribe) {
            case "Мордор":
                factory = new MordorOrkBuilderFactory();
                break;
            case "Дол Гулдур":
                factory = new DolGuldurOrkBuilderFactory();
                break;
            case "Мглистые Горы":
                factory = new MistyMountainsOrkBuilderFactory();
                break;
            default:
                return;
        }

        OrcDirector director = new OrcDirector(factory);
        Ork ork = switch (role) {
            case "Командир" -> director.createLeaderOrk(null);
            case "Разведчик" -> director.createScoutOrk(null);
            default -> director.createBasicOrk(null);
        };

        addOrkToTree(tribe, ork);
    }

    private void addOrkToTree(String tribe, Ork ork) {
        DefaultMutableTreeNode tribeNode = null;

        Enumeration<TreeNode> children = rootNode.children();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) children.nextElement();
            if (node.getUserObject().equals(tribe)) {
                tribeNode = node;
                break;
            }
        }

        if (tribeNode == null) {
            tribeNode = new DefaultMutableTreeNode(tribe);
            rootNode.add(tribeNode);
        }

        DefaultMutableTreeNode orkNode = new DefaultMutableTreeNode(ork.name + " (" + ork.weapon + ")");
        tribeNode.add(orkNode);
        orkMap.put(orkNode, ork);

        treeModel.reload();
        expandAllNodes(armyTree, 0, armyTree.getRowCount());
    }

    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }

        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }

    private void showOrkInfo() {
        orkInfoPanel.removeAll();
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();

        if (selectedNode == null || !orkMap.containsKey(selectedNode)) {
            orkInfoPanel.revalidate();
            orkInfoPanel.repaint();
            return;
        }

        Ork ork = orkMap.get(selectedNode);

        orkInfoPanel.add(new JLabel("Имя: " + ork.name));
        orkInfoPanel.add(new JLabel("Племя: " + ork.tribe));
        orkInfoPanel.add(new JLabel("Оружие: " + ork.weapon));
        orkInfoPanel.add(new JLabel("Броня: " + ork.armor));
        orkInfoPanel.add(new JLabel("Знамя: " + ork.banner));

        orkInfoPanel.add(new JLabel("Сила:"));
        JProgressBar strengthBar = new JProgressBar(0, 100);
        strengthBar.setValue(ork.strength);
        orkInfoPanel.add(strengthBar);

        orkInfoPanel.add(new JLabel("Ловкость:"));
        JProgressBar agilityBar = new JProgressBar(0, 100);
        agilityBar.setValue(ork.agility);
        orkInfoPanel.add(agilityBar);

        orkInfoPanel.add(new JLabel("Интеллект:"));
        JProgressBar intellectBar = new JProgressBar(0, 50);
        intellectBar.setValue(ork.intelligence);
        orkInfoPanel.add(intellectBar);

        orkInfoPanel.add(new JLabel("Здоровье:"));
        JProgressBar healthBar = new JProgressBar(0, 200);
        healthBar.setValue(ork.health);
        orkInfoPanel.add(healthBar);

        orkInfoPanel.revalidate();
        orkInfoPanel.repaint();
    }
}
