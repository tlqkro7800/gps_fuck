

// MainActivity: 아이템 목록을 보여줌
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 각 아이템을 클릭했을 때 해당 아이템을 구매하는 BuyItemActivity로 이동
        item1.setOnClickListener {
            buyItem(Item("item1", 100))
        }

        item2.setOnClickListener {
            buyItem(Item("item2", 200))
        }

        item3.setOnClickListener {
            buyItem(Item("item3", 400))
        }

        item4.setOnClickListener {
            buyItem(Item("item4", 600))
        }
    }

    private fun buyItem(item: Item) {
        val points = 300 // 예시로 사용할 보유 포인트 (실제로는 사용자의 보유 포인트를 여기에서 가져와야 함)

        // 포인트가 가격보다 적으면 "구매할 수 없습니다" 액티비티로 이동
        if (points < item.price) {
            val intent = Intent(this, InsufficientPointsActivity::class.java)
            startActivity(intent)
        } else {
            // 포인트가 가격보다 많으면 "구매 완료" 액티비티로 이동
            val intent = Intent(this, PurchaseResultActivity::class.java)
            startActivity(intent)
        }
    }
}

// InsufficientPointsActivity: 포인트가 부족하여 구매할 수 없음을 보여줌
class InsufficientPointsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insufficient_points)
    }
}

// PurchaseResultActivity: 구매가 완료되었음을 보여줌
class PurchaseResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_result)
    }
}