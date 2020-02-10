// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: passwordhistory.proto

package com.zkartmod;

public final class PasswordHistoryProtos {
  private PasswordHistoryProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface HistoryOrBuilder extends
      // @@protoc_insertion_point(interface_extends:zkartwebapp.History)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 ID = 1;</code>
     * @return The iD.
     */
    int getID();

    /**
     * <code>repeated string password = 3;</code>
     * @return A list containing the password.
     */
    java.util.List<java.lang.String>
        getPasswordList();
    /**
     * <code>repeated string password = 3;</code>
     * @return The count of password.
     */
    int getPasswordCount();
    /**
     * <code>repeated string password = 3;</code>
     * @param index The index of the element to return.
     * @return The password at the given index.
     */
    java.lang.String getPassword(int index);
    /**
     * <code>repeated string password = 3;</code>
     * @param index The index of the value to return.
     * @return The bytes of the password at the given index.
     */
    com.google.protobuf.ByteString
        getPasswordBytes(int index);
  }
  /**
   * Protobuf type {@code zkartwebapp.History}
   */
  public  static final class History extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:zkartwebapp.History)
      HistoryOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use History.newBuilder() to construct.
    private History(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private History() {
      password_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new History();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private History(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {

              iD_ = input.readInt32();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                password_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000001;
              }
              password_.add(s);
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          password_ = password_.getUnmodifiableView();
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.zkartmod.PasswordHistoryProtos.internal_static_zkartwebapp_History_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.zkartmod.PasswordHistoryProtos.internal_static_zkartwebapp_History_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.zkartmod.PasswordHistoryProtos.History.class, com.zkartmod.PasswordHistoryProtos.History.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private int iD_;
    /**
     * <code>int32 ID = 1;</code>
     * @return The iD.
     */
    public int getID() {
      return iD_;
    }

    public static final int PASSWORD_FIELD_NUMBER = 3;
    private com.google.protobuf.LazyStringList password_;
    /**
     * <code>repeated string password = 3;</code>
     * @return A list containing the password.
     */
    public com.google.protobuf.ProtocolStringList
        getPasswordList() {
      return password_;
    }
    /**
     * <code>repeated string password = 3;</code>
     * @return The count of password.
     */
    public int getPasswordCount() {
      return password_.size();
    }
    /**
     * <code>repeated string password = 3;</code>
     * @param index The index of the element to return.
     * @return The password at the given index.
     */
    public java.lang.String getPassword(int index) {
      return password_.get(index);
    }
    /**
     * <code>repeated string password = 3;</code>
     * @param index The index of the value to return.
     * @return The bytes of the password at the given index.
     */
    public com.google.protobuf.ByteString
        getPasswordBytes(int index) {
      return password_.getByteString(index);
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (iD_ != 0) {
        output.writeInt32(1, iD_);
      }
      for (int i = 0; i < password_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, password_.getRaw(i));
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (iD_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, iD_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < password_.size(); i++) {
          dataSize += computeStringSizeNoTag(password_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getPasswordList().size();
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.zkartmod.PasswordHistoryProtos.History)) {
        return super.equals(obj);
      }
      com.zkartmod.PasswordHistoryProtos.History other = (com.zkartmod.PasswordHistoryProtos.History) obj;

      if (getID()
          != other.getID()) return false;
      if (!getPasswordList()
          .equals(other.getPasswordList())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getID();
      if (getPasswordCount() > 0) {
        hash = (37 * hash) + PASSWORD_FIELD_NUMBER;
        hash = (53 * hash) + getPasswordList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.zkartmod.PasswordHistoryProtos.History parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.zkartmod.PasswordHistoryProtos.History parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.zkartmod.PasswordHistoryProtos.History prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code zkartwebapp.History}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:zkartwebapp.History)
        com.zkartmod.PasswordHistoryProtos.HistoryOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.zkartmod.PasswordHistoryProtos.internal_static_zkartwebapp_History_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.zkartmod.PasswordHistoryProtos.internal_static_zkartwebapp_History_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.zkartmod.PasswordHistoryProtos.History.class, com.zkartmod.PasswordHistoryProtos.History.Builder.class);
      }

      // Construct using com.zkartmod.PasswordHistoryProtos.History.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        iD_ = 0;

        password_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.zkartmod.PasswordHistoryProtos.internal_static_zkartwebapp_History_descriptor;
      }

      @java.lang.Override
      public com.zkartmod.PasswordHistoryProtos.History getDefaultInstanceForType() {
        return com.zkartmod.PasswordHistoryProtos.History.getDefaultInstance();
      }

      @java.lang.Override
      public com.zkartmod.PasswordHistoryProtos.History build() {
        com.zkartmod.PasswordHistoryProtos.History result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.zkartmod.PasswordHistoryProtos.History buildPartial() {
        com.zkartmod.PasswordHistoryProtos.History result = new com.zkartmod.PasswordHistoryProtos.History(this);
        int from_bitField0_ = bitField0_;
        result.iD_ = iD_;
        if (((bitField0_ & 0x00000001) != 0)) {
          password_ = password_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.password_ = password_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.zkartmod.PasswordHistoryProtos.History) {
          return mergeFrom((com.zkartmod.PasswordHistoryProtos.History)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.zkartmod.PasswordHistoryProtos.History other) {
        if (other == com.zkartmod.PasswordHistoryProtos.History.getDefaultInstance()) return this;
        if (other.getID() != 0) {
          setID(other.getID());
        }
        if (!other.password_.isEmpty()) {
          if (password_.isEmpty()) {
            password_ = other.password_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePasswordIsMutable();
            password_.addAll(other.password_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.zkartmod.PasswordHistoryProtos.History parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.zkartmod.PasswordHistoryProtos.History) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int iD_ ;
      /**
       * <code>int32 ID = 1;</code>
       * @return The iD.
       */
      public int getID() {
        return iD_;
      }
      /**
       * <code>int32 ID = 1;</code>
       * @param value The iD to set.
       * @return This builder for chaining.
       */
      public Builder setID(int value) {
        
        iD_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 ID = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearID() {
        
        iD_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.LazyStringList password_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensurePasswordIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          password_ = new com.google.protobuf.LazyStringArrayList(password_);
          bitField0_ |= 0x00000001;
         }
      }
      /**
       * <code>repeated string password = 3;</code>
       * @return A list containing the password.
       */
      public com.google.protobuf.ProtocolStringList
          getPasswordList() {
        return password_.getUnmodifiableView();
      }
      /**
       * <code>repeated string password = 3;</code>
       * @return The count of password.
       */
      public int getPasswordCount() {
        return password_.size();
      }
      /**
       * <code>repeated string password = 3;</code>
       * @param index The index of the element to return.
       * @return The password at the given index.
       */
      public java.lang.String getPassword(int index) {
        return password_.get(index);
      }
      /**
       * <code>repeated string password = 3;</code>
       * @param index The index of the value to return.
       * @return The bytes of the password at the given index.
       */
      public com.google.protobuf.ByteString
          getPasswordBytes(int index) {
        return password_.getByteString(index);
      }
      /**
       * <code>repeated string password = 3;</code>
       * @param index The index to set the value at.
       * @param value The password to set.
       * @return This builder for chaining.
       */
      public Builder setPassword(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensurePasswordIsMutable();
        password_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string password = 3;</code>
       * @param value The password to add.
       * @return This builder for chaining.
       */
      public Builder addPassword(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensurePasswordIsMutable();
        password_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string password = 3;</code>
       * @param values The password to add.
       * @return This builder for chaining.
       */
      public Builder addAllPassword(
          java.lang.Iterable<java.lang.String> values) {
        ensurePasswordIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, password_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string password = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearPassword() {
        password_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string password = 3;</code>
       * @param value The bytes of the password to add.
       * @return This builder for chaining.
       */
      public Builder addPasswordBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        ensurePasswordIsMutable();
        password_.add(value);
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:zkartwebapp.History)
    }

    // @@protoc_insertion_point(class_scope:zkartwebapp.History)
    private static final com.zkartmod.PasswordHistoryProtos.History DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.zkartmod.PasswordHistoryProtos.History();
    }

    public static com.zkartmod.PasswordHistoryProtos.History getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<History>
        PARSER = new com.google.protobuf.AbstractParser<History>() {
      @java.lang.Override
      public History parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new History(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<History> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<History> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.zkartmod.PasswordHistoryProtos.History getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_zkartwebapp_History_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_zkartwebapp_History_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025passwordhistory.proto\022\013zkartwebapp\"\'\n\007" +
      "History\022\n\n\002ID\030\001 \001(\005\022\020\n\010password\030\003 \003(\tB%\n" +
      "\014com.zkartmodB\025PasswordHistoryProtosb\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_zkartwebapp_History_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_zkartwebapp_History_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_zkartwebapp_History_descriptor,
        new java.lang.String[] { "ID", "Password", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
