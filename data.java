public class data {
    public static void main(String[] args) {

        String[][] dataDiri = {
                { "1", "Rudi", "1324541" },
                { "2", "Rahmat", "0789654" },
                { "3", "Ayu", "2345345" },
                { "4", "Sari", "5423131" },
                { "5", "Andi", "6463452" },
        };

        int[][] dataNilai = {
                { 80, 70, 90, 87 },
                { 70, 60, 80, 87 },
                { 50, 90, 70, 90 },
                { 60, 78, 78, 80 },
                { 70, 67, 95, 78 },
        };

        // Array untuk menyimpan IPK setiap mahasiswa
        double[] ipkArray = new double[dataDiri.length];

        // Hitung IPK untuk setiap mahasiswa
        for (int i = 0; i < dataDiri.length; i++) {
            int dasarPemrograman = dataNilai[i][0];
            int bahasaIndonesia = dataNilai[i][1];
            int agama = dataNilai[i][2];
            int pancasila = dataNilai[i][3];

            ipkArray[i] = (dasarPemrograman + bahasaIndonesia + agama + pancasila) / 4.0 / 25;
        }

        // Array untuk menggabungkan data IPK dengan indeks mahasiswa
        int[] indexArray = new int[dataDiri.length];
        for (int i = 0; i < dataDiri.length; i++) {
            indexArray[i] = i;
        }

        int[] rankArray = new int[dataDiri.length];

        // Hitung ranking berdasarkan IPK
        for (int i = 0; i < ipkArray.length; i++) {
            int rank = 1; // Default rank
            for (int j = 0; j < ipkArray.length; j++) {
                if (ipkArray[j] > ipkArray[i]) {
                    rank++;
                }
            }
            rankArray[i] = rank;
        }
        // // Sorting berdasarkan IPK secara descending
        // for (int i = 0; i < ipkArray.length - 1; i++) {
        //     for (int j = i + 1; j < ipkArray.length; j++) {
        //         if (ipkArray[indexArray[i]] < ipkArray[indexArray[j]]) {
        //             int temp = indexArray[i];
        //             indexArray[i] = indexArray[j];
        //             indexArray[j] = temp;
        //         }
        //     }
        // }

        System.out.println("+-----+--------+----------+------------------------------------------------------------+---------+-------+------------------+");
        System.out.println("|     |        |          |                Nilai Mata kuliah                           |         |       |                  |");
        System.out.println("|  No |  nama  |   Nim    +--------------------+--------------------+-------+----------+   ipk   | Rank  | Status kelulusan |");
        System.out.println("|     |        |          |  Dasar pemograman  |  bahasa indonesia  |Agama  |Pancasila |         |       |                  |");
        System.out.println("+-----+--------+----------+--------------------+--------------------+-------+----------+---------+-------+------------------+");

        for (int i = 0; i < dataDiri.length; i++) {
            String no = dataDiri[i][0];
            String nama = dataDiri[i][1];
            String nim = dataDiri[i][2];
            int dasarPemrograman = dataNilai[i][0];
            int bahasaIndonesia = dataNilai[i][1];
            int agama = dataNilai[i][2];
            int pancasila = dataNilai[i][3];

            // Tentukan status kelulusan
            String statusKelulusan = ipkArray[i] >= 2.75 ? "Lulus" : "Tidak Lulus";

            // Cetak data
            System.out.printf("| %3s | %-6s | %-8s |        %3d         |        %3d         |  %3d  |    %3d   |  %5.2f  |  %4d | %-16s |\n",
                    no, nama, nim, dasarPemrograman, bahasaIndonesia, agama, pancasila, ipkArray[i], rankArray[i], statusKelulusan);
        }

        System.out.println("+-----+--------+----------+--------------------+--------------------+-------+----------+---------+-------+------------------+");
    }
}
