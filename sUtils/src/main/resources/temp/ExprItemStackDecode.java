package temp;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;

public class ExprItemStackDecode extends Expression {
    private static final String METHOD = """
            
            """;
    public ExprItemStackDecode() {
        super("expr-sitemstack-decode", "Decode Into ItemStack", "ItemStack", "Decode your Base64 code into ItemStack");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.of("org.bukkit.inventory.ItemStack");
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ExpressionParameter("Base64", ClassInfo.STRING)) {
            @Override
            public String toJava() {
                return "PluginMain.toItemStack(" + arg(0) + ")";
            }
        };
    }

    public static org.bukkit.inventory.ItemStack toItemStack(String base64) {

        return (org.bukkit.inventory.ItemStack) item;
    }
}
