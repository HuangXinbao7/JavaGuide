
BMS：图书管理系统
com.atguigu.bms.domain
	Book
		name
		author
		price
		sales
		stock
com.atguigu.bms.service
	BookList
		void addBook(Book book) // 如何保证一定成功, 内部要自动扩容
		Book[] getAllBooks()
		Book getBook(int index)
		boolean deleteBook(int index)
com.atguigu.bms.view
	BookView
		enterMainMenu()