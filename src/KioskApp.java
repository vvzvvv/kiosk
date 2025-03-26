import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KioskApp extends JFrame {
    private List<MenuItem> menuItems;
    private List<MenuItem> cartItems;
    private DefaultListModel<String> cartModel;
    private JLabel totalLabel;
    private int total;

    public KioskApp() {
        menuItems = new ArrayList<>();
        cartItems = new ArrayList<>();
        cartModel = new DefaultListModel<>();
        totalLabel = new JLabel("총 합계: 0 원");
        total = 0;

        initializeMenuItems();
        initializeUI();
    }

    private void initializeMenuItems() {
        menuItems.add(new MenuItem("치즈버거", 5500, 10));
        menuItems.add(new MenuItem("불고기버거", 5300, 2));
        menuItems.add(new MenuItem("세트버거", 7500, 8));
        menuItems.add(new MenuItem("그냥버거", 3800, 15));
    }
    private void updateTotal() {
        total = 0;
        for (MenuItem item : cartItems) {
            total += item.getPrice();
        }
        totalLabel.setText("총 합계: " + total + "원");
    }
    private void initializeUI() {
        setTitle("맥도날드");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Menu Panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        for (MenuItem item : menuItems) {
            JButton button = new JButton(item.getName() + " - " + item.getPrice() + "원");
            button.setEnabled(!item.isSoldOut());

            if (item.isSoldOut()) {
                button.setText(item.getName() + " - 품절 !");
            }

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!item.isSoldOut()) {
                        cartItems.add(item);
                        cartModel.addElement(item.getName() + " - " + item.getPrice() + "원");
                        item.decreaseStock();
                        button.setEnabled(!item.isSoldOut());
                        if (item.isSoldOut()) {
                            button.setText(item.getName() + " - 품절 !");
                        }

                        updateTotal();
                    }
                }
            });
            menuPanel.add(button);

        }

        // 장바구니
        JPanel cartPanel = new JPanel(new BorderLayout());
        JList<String> cartList = new JList<>(cartModel);
        cartPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);
        cartPanel.add(totalLabel, BorderLayout.SOUTH);

        // 장바구니 보기
        JButton viewCartButton = new JButton("장바구니 보기");
        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cartItems.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "장바구니가 비었습니다.");
                } else {
                    JDialog cartDialog = new JDialog(KioskApp.this, "장바구니", true);
                    cartDialog.setLayout(new BorderLayout());

                    JPanel cartDetailsPanel = new JPanel(new BorderLayout());
                    JTextArea cartDetails = new JTextArea();
                    cartDetails.setEditable(false);

                    total = 0;

                    Map<String, Integer> itemCountMap = new LinkedHashMap<>();
                    Map<String, Integer> itemPriceMap = new LinkedHashMap<>();

                    for (MenuItem item : cartItems) {
                        String name = item.getName();
                        int price = item.getPrice();
                        itemCountMap.put(name, itemCountMap.getOrDefault(name, 0) + 1);
                        itemPriceMap.put(name, price);
                    }

                    for (String name : itemCountMap.keySet()) {
                        int quantity = itemCountMap.get(name);
                        int price = itemPriceMap.get(name);
                        int totalPrice = quantity * price;

                        cartDetails.append(name + " x" + quantity + " " + totalPrice + " 원\n");
                        total += totalPrice;
                    }

                    cartDetails.append("\n총 합계: " + total + " 원");
                    cartDetailsPanel.add(new JScrollPane(cartDetails), BorderLayout.CENTER);

                    JButton payButton = new JButton("결제하기");
                    payButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // 쿠폰 입력
                            String coupon = JOptionPane.showInputDialog(cartDialog, "쿠폰 번호를 입력하세요 (없으면 빈칸으로 두세요):");

                            int discountedTotal = total;
                            if (coupon != null && coupon.equals("1234")) {
                                discountedTotal -= 1000;
                                if (discountedTotal < 0) discountedTotal = 0;
                            }

                            JOptionPane.showMessageDialog(cartDialog, "총 결제 금액: " + discountedTotal + " 원");
                            JOptionPane.showMessageDialog(cartDialog, "결제가 완료되었습니다.");
                            cartDialog.dispose();
                        }
                    });

                    // 하단 버튼 패널
                    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    bottomPanel.add(payButton);

                    cartDialog.add(cartDetailsPanel, BorderLayout.CENTER);
                    cartDialog.add(bottomPanel, BorderLayout.SOUTH);
                    cartDialog.setSize(300, 300);
                    cartDialog.setLocationRelativeTo(null);
                    cartDialog.setVisible(true);
                }
            }
        });

        mainPanel.add(menuPanel, BorderLayout.WEST);
        mainPanel.add(cartPanel, BorderLayout.CENTER);
        mainPanel.add(viewCartButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KioskApp());
    }
}







