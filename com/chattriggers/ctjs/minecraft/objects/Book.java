//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects;

import kotlin.*;
import net.minecraft.item.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.*;
import kotlin.jvm.internal.*;
import net.minecraft.init.*;
import com.chattriggers.ctjs.minecraft.objects.message.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import com.chattriggers.ctjs.minecraft.objects.gui.*;
import net.minecraft.client.gui.*;
import kotlin.jvm.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/Book;", "", "bookName", "", "(Ljava/lang/String;)V", "book", "Lnet/minecraft/item/ItemStack;", "bookData", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagCompound;", "bookScreen", "Lnet/minecraft/client/gui/GuiScreenBook;", "addPage", "message", "Lcom/chattriggers/ctjs/minecraft/objects/message/Message;", "display", "", "pageIndex", "", "getCurrentPage", "isOpen", "", "setPage", "updateBookScreen", "pages", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagList;", "ctjs" })
public final class Book
{
    @Nullable
    private GuiScreenBook bookScreen;
    @NotNull
    private final ItemStack book;
    @NotNull
    private final NBTTagCompound bookData;
    
    public Book(@NotNull final String bookName) {
        Intrinsics.checkNotNullParameter((Object)bookName, "bookName");
        this.book = new ItemStack(Items.written_book);
        (this.bookData = new NBTTagCompound(new net.minecraft.nbt.NBTTagCompound())).set("author", new NBTTagString(Player.getName()));
        this.bookData.set("title", new NBTTagString(Intrinsics.stringPlus("CT-", (Object)bookName)));
        this.bookData.set("pages", new NBTTagList());
        this.book.setTagCompound(this.bookData.getRawNBT());
    }
    
    @NotNull
    public final Book addPage(@NotNull final Message message) {
        Intrinsics.checkNotNullParameter((Object)message, "message");
        final Book $this$addPage_u24lambda_u2d0 = this;
        final int n = 0;
        final Object value = $this$addPage_u24lambda_u2d0.bookData.get("pages", NBTTagCompound.NBTDataType.TAG_LIST, 8);
        if (value != null) {
            final com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.NBTTagList pages = new com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.NBTTagList((NBTTagList)value);
            pages.appendTag((NBTBase)new NBTTagString(IChatComponent$Serializer.componentToJson(message.getChatMessage())));
            $this$addPage_u24lambda_u2d0.updateBookScreen(pages);
        }
        return this;
    }
    
    @NotNull
    public final Book addPage(@NotNull final String message) {
        Intrinsics.checkNotNullParameter((Object)message, "message");
        final Book $this$addPage_u24lambda_u2d1 = this;
        final int n = 0;
        $this$addPage_u24lambda_u2d1.addPage(new Message(new Object[] { message }));
        return this;
    }
    
    @NotNull
    public final Book setPage(final int pageIndex, @NotNull final Message message) {
        Intrinsics.checkNotNullParameter((Object)message, "message");
        final Book $this$setPage_u24lambda_u2d2 = this;
        final int n = 0;
        final Object value = $this$setPage_u24lambda_u2d2.bookData.get("pages", NBTTagCompound.NBTDataType.TAG_LIST, 8);
        if (value != null) {
            final com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.NBTTagList pages = new com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.NBTTagList((NBTTagList)value);
            int tagCount = pages.getTagCount();
            if (tagCount <= pageIndex) {
                int i;
                do {
                    i = tagCount;
                    ++tagCount;
                    $this$setPage_u24lambda_u2d2.addPage("");
                } while (i != pageIndex);
            }
            pages.set(pageIndex, (NBTBase)new NBTTagString(IChatComponent$Serializer.componentToJson(message.getChatMessage())));
            $this$setPage_u24lambda_u2d2.updateBookScreen(pages);
        }
        return this;
    }
    
    public final void updateBookScreen(@NotNull final com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.NBTTagList pages) {
        Intrinsics.checkNotNullParameter((Object)pages, "pages");
        this.bookData.removeTag("pages");
        this.bookData.set("pages", pages);
        this.book.setTagCompound(this.bookData.getRawNBT());
        final GuiScreenBook bookScreen = this.bookScreen;
        if (bookScreen != null) {
            bookScreen.bookPages = pages.getRawNBT();
        }
    }
    
    @JvmOverloads
    public final void display(final int pageIndex) {
        this.bookScreen = new GuiScreenBook((EntityPlayer)Player.getPlayer(), this.book, false);
        final GuiScreenBook bookScreen = this.bookScreen;
        Intrinsics.checkNotNull((Object)bookScreen);
        bookScreen.currPage = pageIndex;
        final GuiHandler instance = GuiHandler.INSTANCE;
        final GuiScreenBook bookScreen2 = this.bookScreen;
        if (bookScreen2 == null) {
            return;
        }
        instance.openGui((GuiScreen)bookScreen2);
    }
    
    public static /* synthetic */ void display$default(final Book book, int pageIndex, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            pageIndex = 0;
        }
        book.display(pageIndex);
    }
    
    public final boolean isOpen() {
        return Client.Companion.getMinecraft().currentScreen == this.bookScreen;
    }
    
    public final int getCurrentPage() {
        int currPage;
        if (!this.isOpen() || this.bookScreen == null) {
            currPage = -1;
        }
        else {
            final GuiScreenBook bookScreen = this.bookScreen;
            Intrinsics.checkNotNull((Object)bookScreen);
            currPage = bookScreen.currPage;
        }
        return currPage;
    }
    
    @JvmOverloads
    public final void display() {
        display$default(this, 0, 1, null);
    }
}
