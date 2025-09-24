
---

## ✨ Features Implemented

- ✅ **Restaurant Management** (add/search restaurants)  
- ✅ **Menu & Cart Management** (add items, view cart, total cost)  
- ✅ **Orders** (Now Orders & Scheduled Orders using Factory Pattern)  
- ✅ **Payments** (UPI / Credit Card using Strategy Pattern)  
- ✅ **Notifications** after successful payment  
- ✅ **Singleton Managers** for shared state across app  

---

## 🛠️ Design Patterns Used

- **Singleton** → `RestaurantManager`, `OrderManager`  
- **Factory Method** → `OrderFactory`, `NowOrderFactory`, `ScheduledOrderFactory`  
- **Strategy** → `PaymentStrategy` (UPI, CreditCard)  
- **Facade** → `TomatoApp` (exposes simplified interface for ordering)  

---

