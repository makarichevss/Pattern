package HW4;

import java.nio.charset.StandardCharsets;

public class ByteAdapter extends StringProvider {
    private ByteProvider provider;

    public ByteAdapter(ByteProvider provider) {
        this.provider = provider;
    }

    @Override
    public String getData() {
        return new String(provider.getData(), StandardCharsets.UTF_8);
    }
}
