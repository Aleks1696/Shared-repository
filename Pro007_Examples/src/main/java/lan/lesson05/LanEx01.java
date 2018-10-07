package lan.lesson05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Objects;

public class LanEx01 {

    /* Сетевое взаимодействие
    *
    * Protocol - описывает набор правил для
    * интерактивного обмена информацией между
    * компьютерами в рамках сети
    *
    * TCP/IP
    * Tranmission Control Protocol - основная задача
    * протокола заключается в том, чтобы гарантировать
    * передачу данных между компьютерами в рамках сети
    * Internet Protocol - основная задача протокола,
    * решение комуникационных вопросов, возникающих
    * в процессе передачи данных
    *
    * IPv4:
    * XXX.XXX.XXX.XXX
    * 127.0.0.1 - необходим для тестов в пределах одного
    * компьютера (localhost)
    * */
    public static void main(String[] args) {
        /* SocketChannel - класс необходим для подключения к
         * удаленному ресурсу
         * hostname - адрес ПК в сети
         * port     - порт любой в диапазоне (8081...65535)*/
        try (SocketChannel channel = SocketChannel.open(
                new InetSocketAddress("127.0.0.1", 20000))) {
            String text = "Тестовое сообщение!";

            ByteBuffer buffer = ByteBuffer.allocate(128);
            buffer.put(text.getBytes());
            buffer.flip();


            channel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
