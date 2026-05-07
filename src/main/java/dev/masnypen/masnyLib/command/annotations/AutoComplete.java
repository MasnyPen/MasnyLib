package dev.masnypen.masnyLib.command.annotations;

import dev.masnypen.masnyLib.command.context.completions.CompletionProvider;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(AutoCompletes.class)
public @interface AutoComplete {
    int index() default 0;
    Class<? extends CompletionProvider> value();
}
