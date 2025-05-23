# Pemrograman4-UMB

# 📱 Aplikasi Android Login & Register

Aplikasi Android dengan fitur **Register dan Login menggunakan API PHP & MySQL**, dibuat dengan Java dan Retrofit.  
Tampilan modern, validasi lengkap, dan menampilkan "Selamat Datang, [nama]" di dashboard.

---

## 🚀 Fitur Utama

- ✅ Register akun (validasi password & konfirmasi password)
- ✅ Login akun (validasi form & login ke backend)
- ✅ Menampilkan nama pengguna di halaman dashboard setelah login
- ✅ Backend PHP + MySQL
- ❌ (Belum) Integrasi Google Login *(opsional, bisa ditambahkan)*

---

## 🧩 Alur Aplikasi

### 🔁 Alur Lengkap Aplikasi

1. User membuka aplikasi → tampil halaman Login

2. Jika belum punya akun:
   → Klik tombol "Register"
   → Tampil halaman Register
   → Isi form: Nama, Username, Password, Konfirmasi Password
   → Validasi:
       - Semua field wajib diisi
       - Password minimal 6 karakter
       - Password dan konfirmasi harus sama
   → Kirim data ke backend API PHP
   → Jika sukses → kembali ke halaman Login

3. Jika sudah punya akun:
   → Isi Username & Password
   → Validasi tidak boleh kosong
   → Kirim data ke API Login
   → Jika login sukses:
       → Pindah ke halaman Dashboard
       → Tampilkan: "Selamat datang, [nama pengguna]"


# Screenshot aplikasi

## Tampilan Login

![Tampilan Aplikasi](screenshot/Screenshot%202025-05-23%20090637.png)

## Tampilan Register

![Tampilan Aplikasi](screenshot/Screenshot%202025-05-23%20090334.png)

## Validasi Login Gagal

![Tampilan Aplikasi](screenshot/Screenshot%202025-05-22%22225124.png)

## Validasi Password Kurang dari 6 Karakter

![Tampilan Aplikasi](screenshot/Screenshot%202025-05-22%22230402.png)

## Login Berhasil

![Tampilan Aplikasi](screenshot/Screenshot%202025-05-22%22230510.png)




