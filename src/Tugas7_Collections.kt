/* NAMA : M. Bayu Aji
NIM  : F1D02310144
Tugas 7 - Manajemen Data dengan Collections
*/

// Blueprint buat data mahasiswa, isinya NIM, Nama, Matkul, sama Nilai
data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val matakuliah: String,
    val nilai: Int
)

// Fungsi buat nentuin dapet grade apa dari skor yang ada
fun getGrade(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E" // Kalo di bawah 50  dapet E
    }
}

fun main() {
    // Masukin data mahasiswa di sini, minimal 10 orang sesuai instruksi tugas
    val listMahasiswa = listOf(
        NilaiMahasiswa("F1D02310001", "Pablo", "Pemrograman", 76),
        NilaiMahasiswa("F1D02310002", "Bayu", "Pemrograman", 95),
        NilaiMahasiswa("F1D02310003", "Vincenzo", "Pemrograman", 69),
        NilaiMahasiswa("F1D02310004", "Florien", "Pemrograman", 50),
        NilaiMahasiswa("F1D02310005", "Ravindra", "Pemrograman", 66),
        NilaiMahasiswa("F1D02310006", "Erenoah", "Pemrograman", 84),
        NilaiMahasiswa("F1D02310007", "Calista", "Pemrograman", 71),
        NilaiMahasiswa("F1D02310008", "Giselle", "Pemrograman", 59),
        NilaiMahasiswa("F1D02310009", "Ray", "Pemrograman", 49),
        NilaiMahasiswa("F1D02310010", "Ling", "Pemrograman", 80)
    )

    // Bagian buat nampilin semua data ke layar pake format tabel biar rapi
    println("===== DATA NILAI MAHASISWA =====")
    println("%-4s %-12s %-20s %-15s %-5s".format("No", "NIM", "Nama", "MataKuliah", "Nilai"))
    listMahasiswa.forEachIndexed { i, m ->
        println("%-4d %-12s %-20s %-15s %-5d".format(i + 1, m.nim, m.nama, m.matakuliah, m.nilai))
    }

    // Hitung-hitungan statistik: nyari yang paling jago, yang paling apes, sama rata-ratanya
    println("\n===== STATISTIK =====")
    val tertinggi = listMahasiswa.maxByOrNull { it.nilai }
    val terendah = listMahasiswa.minByOrNull { it.nilai }

    println("Total Mahasiswa : ${listMahasiswa.size}")
    println("Rata-rata Nilai : %.1f".format(listMahasiswa.map { it.nilai }.average()))
    println("Nilai Tertinggi : ${tertinggi?.nilai} (${tertinggi?.nama})")
    println("Nilai Terendah  : ${terendah?.nilai} (${terendah?.nama})")

    // Pisahin mahasiswa jadi dua kubu: yang lulus (>= 70) sama yang harus ngulang (< 70)
    val (lulus, tidakLulus) = listMahasiswa.partition { it.nilai >= 70 }

    println("\n===== MAHASISWA LULUS =====")
    lulus.forEachIndexed { i, m -> println("${i + 1}. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})") }

    println("\n===== MAHASISWA TIDAK LULUS =====")
    tidakLulus.forEachIndexed { i, m -> println("${i + 1}. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})") }

    // Urutin data dari yang terkecil (Ascending) dan yang terbesar (Descending)
    println("\n===== URUTAN NILAI (ASCENDING) =====")
    listMahasiswa.sortedBy { it.nilai }.forEach { println("${it.nilai} - ${it.nama}") }

    println("\n===== URUTAN NILAI (DESCENDING) =====")
    listMahasiswa.sortedByDescending { it.nilai }.forEach { println("${it.nilai} - ${it.nama}") }

    // Kelompokkin berapa banyak orang yang dapet A, B, sampe E
    println("\n===== JUMLAH PER GRADE =====")
    val grouped = listMahasiswa.groupBy { getGrade(it.nilai) }
    "ABCDE".forEach { gradeChar ->
        val key = gradeChar.toString()
        val count = grouped[key]?.size ?: 0
        println("Grade $key: $count mahasiswa")
    }

    // Fitur buat nyari nama mahasiswa (nggak perlu ngetik nama lengkap, yang penting ada kata kuncinya)
    val keyword = "Pablo"
    println("\n===== PENCARIAN MAHASISWA ('$keyword') =====")
    listMahasiswa.filter { it.nama.contains(keyword, true) }.forEach {
        println("- ${it.nama} (NIM: ${it.nim})")
    }
}