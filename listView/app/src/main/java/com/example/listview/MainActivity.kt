package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var listView:ListView
    private lateinit var userAdapter: userAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        val users = ArrayList<User>()
        users.add(User("Sohail", "Montes", "https://etimg.etb2bimg.com/photo/72306162.cms"))
        users.add(User("Elyas", "Medina", "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/rrswbphev006.jpg?itok=9I7wPblq"))
        users.add(User("Mimi", "Delarossa", "https://media.gq-magazine.co.uk/photos/5e2990790d262400081ba993/master/w_1920,c_limit/20200123-Sports-Cars-06.jpg"))
        users.add(User("Sohail", "Montes", "https://etimg.etb2bimg.com/photo/72306162.cms"))
        users.add(User("Elyas", "Medina", "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/rrswbphev006.jpg?itok=9I7wPblq"))
        users.add(User("Mimi", "Delarossa", "https://media.gq-magazine.co.uk/photos/5e2990790d262400081ba993/master/w_1920,c_limit/20200123-Sports-Cars-06.jpg"))
        users.add(User("Sohail", "Montes", "https://etimg.etb2bimg.com/photo/72306162.cms"))
        users.add(User("Elyas", "Medina", "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/rrswbphev006.jpg?itok=9I7wPblq"))
        users.add(User("Miadami", "Delarossa", "https://media.gq-magazine.co.uk/photos/5e2990790d262400081ba993/master/w_1920,c_limit/20200123-Sports-Cars-06.jpg"))
        users.add(User("Sohail", "Montes", "https://etimg.etb2bimg.com/photo/72306162.cms"))
        users.add(User("Elyaadas", "Medina", "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/rrswbphev006.jpg?itok=9I7wPblq"))
        users.add(User("Mimi", "Delarossa", "https://media.gq-magazine.co.uk/photos/5e2990790d262400081ba993/master/w_1920,c_limit/20200123-Sports-Cars-06.jpg"))
        users.add(User("Sohail", "Moadantes", "https://etimg.etb2bimg.com/photo/72306162.cms"))
        users.add(User("Elyas", "Medina", "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/rrswbphev006.jpg?itok=9I7wPblq"))
        users.add(User("Mimi", "Delarossa", "https://media.gq-magazine.co.uk/photos/5e2990790d262400081ba993/master/w_1920,c_limit/20200123-Sports-Cars-06.jpg"))
        users.add(User("Sohail", "Montes", "https://etimg.etb2bimg.com/photo/72306162.cms"))
        users.add(User("Elyas", "Medina", "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/rrswbphev006.jpg?itok=9I7wPblq"))
        users.add(User("Mimi", "Delarossa", "https://media.gq-magazine.co.uk/photos/5e2990790d262400081ba993/master/w_1920,c_limit/20200123-Sports-Cars-06.jpg"))
        users.add(User("Sohail", "Montes", "https://etimg.etb2bimg.com/photo/72306162.cms"))
        users.add(User("Elyas", "Medina", "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/rrswbphev006.jpg?itok=9I7wPblq"))
        users.add(User("Mimcsci", "Delarsfsdfossa", "https://media.gq-magazine.co.uk/photos/5e2990790d262400081ba993/master/w_1920,c_limit/20200123-Sports-Cars-06.jpg"))
        users.add(User("Sohail", "Montes", "https://etimg.etb2bimg.com/photo/72306162.cms"))
        users.add(User("Elyas", "Medina", "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/rrswbphev006.jpg?itok=9I7wPblq"))
        users.add(User("Mimsfsi", "Delsfsfarossa", "https://media.gq-magazine.co.uk/photos/5e2990790d262400081ba993/master/w_1920,c_limit/20200123-Sports-Cars-06.jpg"))
        users.add(User("Sohail", "Montes", "https://etimg.etb2bimg.com/photo/72306162.cms"))
        users.add(User("Elsdadyas", "Medina", "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/rrswbphev006.jpg?itok=9I7wPblq"))
        users.add(User("Mimidad", "Delarossa", "https://media.gq-magazine.co.uk/photos/5e2990790d262400081ba993/master/w_1920,c_limit/20200123-Sports-Cars-06.jpg"))
        users.add(User("Sohail", "Moadasntes", "https://etimg.etb2bimg.com/photo/72306162.cms"))
        users.add(User("Elyas", "Medadasina", "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/rrswbphev006.jpg?itok=9I7wPblq"))
        users.add(User("Mimi", "Delaadrossa", "https://media.gq-magazine.co.uk/photos/5e2990790d262400081ba993/master/w_1920,c_limit/20200123-Sports-Cars-06.jpg"))

        userAdapter = userAdapter(this, users)
        listView.adapter = userAdapter

    }
}