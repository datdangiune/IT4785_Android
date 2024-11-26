package vn.edu.hust.studentman

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

  private lateinit var listView: ListView
  private lateinit var students: ArrayList<Student>
  private lateinit var adapter: ArrayAdapter<Student>

  companion object {
    const val REQUEST_ADD = 1
    const val REQUEST_EDIT = 2
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Thiết lập Toolbar
    val toolbar: Toolbar = findViewById(R.id.toolbar)
    setSupportActionBar(toolbar)

    // Khởi tạo ListView và danh sách sinh viên
    listView = findViewById(R.id.studentListView)
    students = ArrayList()
    students.add(Student("Nguyen Van A", "12345"))
    students.add(Student("Tran Thi B", "67890"))

    // Thiết lập Adapter cho ListView
    adapter = ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, students)
    listView.adapter = adapter

    // Đăng ký Context Menu cho ListView
    registerForContextMenu(listView)
  }

  // Tạo Option Menu (Add new)
  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.add_new -> {
        // Chuyển đến AddStudentActivity
        val intent = Intent(this, AddStudentActivity::class.java)
        startActivityForResult(intent, REQUEST_ADD)
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  // Tạo Context Menu (Edit & Remove)
  override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
    super.onCreateContextMenu(menu, v, menuInfo)
    menuInflater.inflate(R.menu.context_menu, menu)
  }

  override fun onContextItemSelected(item: MenuItem): Boolean {
    val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
    val position = info.position
    val selectedStudent = students[position]

    return when (item.itemId) {
      R.id.edit -> {
        // Chuyển đến EditStudentActivity
        val editIntent = Intent(this, EditStudentActivity::class.java)
        editIntent.putExtra("student_id", selectedStudent.studentId)
        editIntent.putExtra("student_name", selectedStudent.name)
        editIntent.putExtra("position", position)
        startActivityForResult(editIntent, REQUEST_EDIT)
        true
      }
      R.id.remove -> {
        // Xóa sinh viên
        students.removeAt(position)
        adapter.notifyDataSetChanged()
        true
      }
      else -> super.onContextItemSelected(item)
    }
  }

  // Nhận kết quả trả về từ AddStudentActivity và EditStudentActivity
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == RESULT_OK && data != null) {
      when (requestCode) {
        REQUEST_ADD -> {
          val name = data.getStringExtra("student_name")
          val studentId = data.getStringExtra("student_id")
          if (name != null && studentId != null) {
            students.add(Student(name, studentId))
            adapter.notifyDataSetChanged()
          }
        }
        REQUEST_EDIT -> {
          val position = data.getIntExtra("position", -1)
          val name = data.getStringExtra("student_name")
          val studentId = data.getStringExtra("student_id")
          if (position != -1 && name != null && studentId != null) {
            students[position] = Student(name, studentId)
            adapter.notifyDataSetChanged()
          }
        }
      }
    }
  }
}