/* NAMA : M. Bayu Aji
NIM  : F1D02310144
Tugas 3 - Sistem Penilaian
*/

import java.util.Scanner

fun main() {
    // Bikin scanner biar bisa ngetik-ngetik input di terminal
    val scanner = Scanner(System.`in`)

    println("===== SISTEM PENILAIAN =====\n")

    // Bagian ambil data dari user
    print("Masukkan Nama Mahasiswa: ")
    val nama = scanner.nextLine()

    print("Masukkan Nilai UTS (0-100): ")
    val uts = scanner.nextDouble()

    print("Masukkan Nilai UAS (0-100): ")
    val uas = scanner.nextDouble()

    print("Masukkan Nilai Tugas (0-100): ")
    val tugas = scanner.nextDouble()

    // Hitung nilai akhir sesuai bobot: UTS 30%, UAS 40%, Tugas 30%
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    // Nentuin Grade pake 'when' biar gampang dibaca, pake range (in ..) sesuai hint
    val grade = when (nilaiAkhir) {
        in 85.0..100.0 -> "A"
        in 70.0..84.0 -> "B"
        in 60.0..69.0 -> "C"
        in 50.0..59.0 -> "D"
        in 0.0..49.0 -> "E"
        else -> "Tidak Valid" // Buat jaga-jaga kalau inputnya ngaco
    }

    // Kasih keterangan tambahan berdasarkan grade yang didapet
    val keterangan = when (grade) {
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        "E" -> "Sangat Kurang"
        else -> "Nilai Tidak Valid"
    }

    // Syarat lulus minimal dapet nilai 60
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    // Tampilan hasil akhirnya, dibikin rapi pake format string
    println("\n===== HASIL PENILAIAN =====")
    println("%-12s : %s".format("Nama", nama))
    println("%-12s : %.0f (Bobot 30%%)".format("Nilai UTS", uts))
    println("%-12s : %.0f (Bobot 40%%)".format("Nilai UAS", uas))
    println("%-12s : %.0f (Bobot 30%%)".format("Nilai Tugas", tugas))

    println("-----------------------------")

    println("%-12s : %.1f".format("Nilai Akhir", nilaiAkhir))
    println("%-12s : %s".format("Grade", grade))
    println("%-12s : %s".format("Keterangan", keterangan))
    println("%-12s : %s".format("Status", status))

    // Pesan penutup buat penyemangat (atau peringatan hehe)
    println()
    if (status == "LULUS") {
        println("Selamat! Anda dinyatakan LULUS.")
    } else {
        println("Tetap semangat! Anda dinyatakan TIDAK LULUS.")
    }
}