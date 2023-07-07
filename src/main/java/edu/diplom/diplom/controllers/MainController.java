package edu.diplom.diplom.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import edu.diplom.diplom.controllers.utils.QRcodeGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Paths;


@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "/home";
    }

    @GetMapping("/qr-create")
    public String qrcreate(Model model) throws IOException, WriterException {
        model.addAttribute("title", "Генерация QR-кода");
        QRcodeGenerator.QRGenerate();
        return "/qr-create";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Про нас");
        return "about";

    }

    @GetMapping("/faq")
    public String faq(Model model) {
        model.addAttribute("title", "FAQ");
        return "faq";

    }
}
