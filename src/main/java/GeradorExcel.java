import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GeradorExcel {
    public void salvaExcel(List<Usuario> usuarios) throws IOException {
        // Criando uma nova planilha
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Usuarios");

        // Criando a linha de cabeçalho
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Location");
        headerRow.createCell(2).setCellValue("Avatar_url");

        // Criando uma linha para cada objeto Usuario da lista
        int rowNum = 1;
        for (Usuario usuario : usuarios) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(usuario.name());
            row.createCell(1).setCellValue(usuario.location());
            row.createCell(2).setCellValue(usuario.avatar_url());
        }

        // Ajustar automaticamente a largura das colunas
        for (int i = 0; i < 7; i++) {
            sheet.autoSizeColumn(i);
        }

        // Salvando o arquivo Excel
        try (FileOutputStream fileOut = new FileOutputStream("usuarios.xlsx")) {
            workbook.write(fileOut);
        }

        // Fechando o Workbook
        workbook.close();
    }

    // Método auxiliar para criar uma linha na planilha
    private void criaLinha(Sheet sheet, int rowNum, String campo, String valor) {
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(campo);
        row.createCell(1).setCellValue(valor);
    }
}
