// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: userinfo.proto

package com.zkartmod;

public final class UserInfoProtos {
  private UserInfoProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface UserInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:zkart.UserInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string mail = 1;</code>
     * @return The mail.
     */
    java.lang.String getMail();
    /**
     * <code>string mail = 1;</code>
     * @return The bytes for mail.
     */
    com.google.protobuf.ByteString
        getMailBytes();

    /**
     * <code>string name = 2;</code>
     * @return The name.
     */
    java.lang.String getName();
    /**
     * <code>string name = 2;</code>
     * @return The bytes for name.
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>string phoneNumber = 3;</code>
     * @return The phoneNumber.
     */
    java.lang.String getPhoneNumber();
    /**
     * <code>string phoneNumber = 3;</code>
     * @return The bytes for phoneNumber.
     */
    com.google.protobuf.ByteString
        getPhoneNumberBytes();

    /**
     * <code>int32 noOfPurchases = 4;</code>
     * @return The noOfPurchases.
     */
    int getNoOfPurchases();

    /**
     * <code>string discountCode = 5;</code>
     * @return The discountCode.
     */
    java.lang.String getDiscountCode();
    /**
     * <code>string discountCode = 5;</code>
     * @return The bytes for discountCode.
     */
    com.google.protobuf.ByteString
        getDiscountCodeBytes();

    /**
     * <code>int32 discountValidity = 6;</code>
     * @return The discountValidity.
     */
    int getDiscountValidity();
  }
  /**
   * Protobuf type {@code zkart.UserInfo}
   */
  public  static final class UserInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:zkart.UserInfo)
      UserInfoOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use UserInfo.newBuilder() to construct.
    private UserInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private UserInfo() {
      mail_ = "";
      name_ = "";
      phoneNumber_ = "";
      discountCode_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new UserInfo();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private UserInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              mail_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              name_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              phoneNumber_ = s;
              break;
            }
            case 32: {

              noOfPurchases_ = input.readInt32();
              break;
            }
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();

              discountCode_ = s;
              break;
            }
            case 48: {

              discountValidity_ = input.readInt32();
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.zkartmod.UserInfoProtos.internal_static_zkart_UserInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.zkartmod.UserInfoProtos.internal_static_zkart_UserInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.zkartmod.UserInfoProtos.UserInfo.class, com.zkartmod.UserInfoProtos.UserInfo.Builder.class);
    }

    public static final int MAIL_FIELD_NUMBER = 1;
    private volatile java.lang.Object mail_;
    /**
     * <code>string mail = 1;</code>
     * @return The mail.
     */
    public java.lang.String getMail() {
      java.lang.Object ref = mail_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        mail_ = s;
        return s;
      }
    }
    /**
     * <code>string mail = 1;</code>
     * @return The bytes for mail.
     */
    public com.google.protobuf.ByteString
        getMailBytes() {
      java.lang.Object ref = mail_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        mail_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int NAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object name_;
    /**
     * <code>string name = 2;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PHONENUMBER_FIELD_NUMBER = 3;
    private volatile java.lang.Object phoneNumber_;
    /**
     * <code>string phoneNumber = 3;</code>
     * @return The phoneNumber.
     */
    public java.lang.String getPhoneNumber() {
      java.lang.Object ref = phoneNumber_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        phoneNumber_ = s;
        return s;
      }
    }
    /**
     * <code>string phoneNumber = 3;</code>
     * @return The bytes for phoneNumber.
     */
    public com.google.protobuf.ByteString
        getPhoneNumberBytes() {
      java.lang.Object ref = phoneNumber_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        phoneNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int NOOFPURCHASES_FIELD_NUMBER = 4;
    private int noOfPurchases_;
    /**
     * <code>int32 noOfPurchases = 4;</code>
     * @return The noOfPurchases.
     */
    public int getNoOfPurchases() {
      return noOfPurchases_;
    }

    public static final int DISCOUNTCODE_FIELD_NUMBER = 5;
    private volatile java.lang.Object discountCode_;
    /**
     * <code>string discountCode = 5;</code>
     * @return The discountCode.
     */
    public java.lang.String getDiscountCode() {
      java.lang.Object ref = discountCode_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        discountCode_ = s;
        return s;
      }
    }
    /**
     * <code>string discountCode = 5;</code>
     * @return The bytes for discountCode.
     */
    public com.google.protobuf.ByteString
        getDiscountCodeBytes() {
      java.lang.Object ref = discountCode_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        discountCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DISCOUNTVALIDITY_FIELD_NUMBER = 6;
    private int discountValidity_;
    /**
     * <code>int32 discountValidity = 6;</code>
     * @return The discountValidity.
     */
    public int getDiscountValidity() {
      return discountValidity_;
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
      if (!getMailBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, mail_);
      }
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
      }
      if (!getPhoneNumberBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, phoneNumber_);
      }
      if (noOfPurchases_ != 0) {
        output.writeInt32(4, noOfPurchases_);
      }
      if (!getDiscountCodeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, discountCode_);
      }
      if (discountValidity_ != 0) {
        output.writeInt32(6, discountValidity_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getMailBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, mail_);
      }
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
      }
      if (!getPhoneNumberBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, phoneNumber_);
      }
      if (noOfPurchases_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, noOfPurchases_);
      }
      if (!getDiscountCodeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, discountCode_);
      }
      if (discountValidity_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(6, discountValidity_);
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
      if (!(obj instanceof com.zkartmod.UserInfoProtos.UserInfo)) {
        return super.equals(obj);
      }
      com.zkartmod.UserInfoProtos.UserInfo other = (com.zkartmod.UserInfoProtos.UserInfo) obj;

      if (!getMail()
          .equals(other.getMail())) return false;
      if (!getName()
          .equals(other.getName())) return false;
      if (!getPhoneNumber()
          .equals(other.getPhoneNumber())) return false;
      if (getNoOfPurchases()
          != other.getNoOfPurchases()) return false;
      if (!getDiscountCode()
          .equals(other.getDiscountCode())) return false;
      if (getDiscountValidity()
          != other.getDiscountValidity()) return false;
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
      hash = (37 * hash) + MAIL_FIELD_NUMBER;
      hash = (53 * hash) + getMail().hashCode();
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      hash = (37 * hash) + PHONENUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getPhoneNumber().hashCode();
      hash = (37 * hash) + NOOFPURCHASES_FIELD_NUMBER;
      hash = (53 * hash) + getNoOfPurchases();
      hash = (37 * hash) + DISCOUNTCODE_FIELD_NUMBER;
      hash = (53 * hash) + getDiscountCode().hashCode();
      hash = (37 * hash) + DISCOUNTVALIDITY_FIELD_NUMBER;
      hash = (53 * hash) + getDiscountValidity();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.zkartmod.UserInfoProtos.UserInfo parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.zkartmod.UserInfoProtos.UserInfo parseFrom(
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
    public static Builder newBuilder(com.zkartmod.UserInfoProtos.UserInfo prototype) {
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
     * Protobuf type {@code zkart.UserInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:zkart.UserInfo)
        com.zkartmod.UserInfoProtos.UserInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.zkartmod.UserInfoProtos.internal_static_zkart_UserInfo_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.zkartmod.UserInfoProtos.internal_static_zkart_UserInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.zkartmod.UserInfoProtos.UserInfo.class, com.zkartmod.UserInfoProtos.UserInfo.Builder.class);
      }

      // Construct using com.zkartmod.UserInfoProtos.UserInfo.newBuilder()
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
        mail_ = "";

        name_ = "";

        phoneNumber_ = "";

        noOfPurchases_ = 0;

        discountCode_ = "";

        discountValidity_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.zkartmod.UserInfoProtos.internal_static_zkart_UserInfo_descriptor;
      }

      @java.lang.Override
      public com.zkartmod.UserInfoProtos.UserInfo getDefaultInstanceForType() {
        return com.zkartmod.UserInfoProtos.UserInfo.getDefaultInstance();
      }

      @java.lang.Override
      public com.zkartmod.UserInfoProtos.UserInfo build() {
        com.zkartmod.UserInfoProtos.UserInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.zkartmod.UserInfoProtos.UserInfo buildPartial() {
        com.zkartmod.UserInfoProtos.UserInfo result = new com.zkartmod.UserInfoProtos.UserInfo(this);
        result.mail_ = mail_;
        result.name_ = name_;
        result.phoneNumber_ = phoneNumber_;
        result.noOfPurchases_ = noOfPurchases_;
        result.discountCode_ = discountCode_;
        result.discountValidity_ = discountValidity_;
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
        if (other instanceof com.zkartmod.UserInfoProtos.UserInfo) {
          return mergeFrom((com.zkartmod.UserInfoProtos.UserInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.zkartmod.UserInfoProtos.UserInfo other) {
        if (other == com.zkartmod.UserInfoProtos.UserInfo.getDefaultInstance()) return this;
        if (!other.getMail().isEmpty()) {
          mail_ = other.mail_;
          onChanged();
        }
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (!other.getPhoneNumber().isEmpty()) {
          phoneNumber_ = other.phoneNumber_;
          onChanged();
        }
        if (other.getNoOfPurchases() != 0) {
          setNoOfPurchases(other.getNoOfPurchases());
        }
        if (!other.getDiscountCode().isEmpty()) {
          discountCode_ = other.discountCode_;
          onChanged();
        }
        if (other.getDiscountValidity() != 0) {
          setDiscountValidity(other.getDiscountValidity());
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
        com.zkartmod.UserInfoProtos.UserInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.zkartmod.UserInfoProtos.UserInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object mail_ = "";
      /**
       * <code>string mail = 1;</code>
       * @return The mail.
       */
      public java.lang.String getMail() {
        java.lang.Object ref = mail_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          mail_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string mail = 1;</code>
       * @return The bytes for mail.
       */
      public com.google.protobuf.ByteString
          getMailBytes() {
        java.lang.Object ref = mail_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          mail_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string mail = 1;</code>
       * @param value The mail to set.
       * @return This builder for chaining.
       */
      public Builder setMail(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        mail_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string mail = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearMail() {
        
        mail_ = getDefaultInstance().getMail();
        onChanged();
        return this;
      }
      /**
       * <code>string mail = 1;</code>
       * @param value The bytes for mail to set.
       * @return This builder for chaining.
       */
      public Builder setMailBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        mail_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object name_ = "";
      /**
       * <code>string name = 2;</code>
       * @return The name.
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string name = 2;</code>
       * @return The bytes for name.
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string name = 2;</code>
       * @param value The name to set.
       * @return This builder for chaining.
       */
      public Builder setName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string name = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearName() {
        
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>string name = 2;</code>
       * @param value The bytes for name to set.
       * @return This builder for chaining.
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        name_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object phoneNumber_ = "";
      /**
       * <code>string phoneNumber = 3;</code>
       * @return The phoneNumber.
       */
      public java.lang.String getPhoneNumber() {
        java.lang.Object ref = phoneNumber_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          phoneNumber_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string phoneNumber = 3;</code>
       * @return The bytes for phoneNumber.
       */
      public com.google.protobuf.ByteString
          getPhoneNumberBytes() {
        java.lang.Object ref = phoneNumber_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          phoneNumber_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string phoneNumber = 3;</code>
       * @param value The phoneNumber to set.
       * @return This builder for chaining.
       */
      public Builder setPhoneNumber(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        phoneNumber_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string phoneNumber = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearPhoneNumber() {
        
        phoneNumber_ = getDefaultInstance().getPhoneNumber();
        onChanged();
        return this;
      }
      /**
       * <code>string phoneNumber = 3;</code>
       * @param value The bytes for phoneNumber to set.
       * @return This builder for chaining.
       */
      public Builder setPhoneNumberBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        phoneNumber_ = value;
        onChanged();
        return this;
      }

      private int noOfPurchases_ ;
      /**
       * <code>int32 noOfPurchases = 4;</code>
       * @return The noOfPurchases.
       */
      public int getNoOfPurchases() {
        return noOfPurchases_;
      }
      /**
       * <code>int32 noOfPurchases = 4;</code>
       * @param value The noOfPurchases to set.
       * @return This builder for chaining.
       */
      public Builder setNoOfPurchases(int value) {
        
        noOfPurchases_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 noOfPurchases = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearNoOfPurchases() {
        
        noOfPurchases_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object discountCode_ = "";
      /**
       * <code>string discountCode = 5;</code>
       * @return The discountCode.
       */
      public java.lang.String getDiscountCode() {
        java.lang.Object ref = discountCode_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          discountCode_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string discountCode = 5;</code>
       * @return The bytes for discountCode.
       */
      public com.google.protobuf.ByteString
          getDiscountCodeBytes() {
        java.lang.Object ref = discountCode_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          discountCode_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string discountCode = 5;</code>
       * @param value The discountCode to set.
       * @return This builder for chaining.
       */
      public Builder setDiscountCode(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        discountCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string discountCode = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearDiscountCode() {
        
        discountCode_ = getDefaultInstance().getDiscountCode();
        onChanged();
        return this;
      }
      /**
       * <code>string discountCode = 5;</code>
       * @param value The bytes for discountCode to set.
       * @return This builder for chaining.
       */
      public Builder setDiscountCodeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        discountCode_ = value;
        onChanged();
        return this;
      }

      private int discountValidity_ ;
      /**
       * <code>int32 discountValidity = 6;</code>
       * @return The discountValidity.
       */
      public int getDiscountValidity() {
        return discountValidity_;
      }
      /**
       * <code>int32 discountValidity = 6;</code>
       * @param value The discountValidity to set.
       * @return This builder for chaining.
       */
      public Builder setDiscountValidity(int value) {
        
        discountValidity_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 discountValidity = 6;</code>
       * @return This builder for chaining.
       */
      public Builder clearDiscountValidity() {
        
        discountValidity_ = 0;
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


      // @@protoc_insertion_point(builder_scope:zkart.UserInfo)
    }

    // @@protoc_insertion_point(class_scope:zkart.UserInfo)
    private static final com.zkartmod.UserInfoProtos.UserInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.zkartmod.UserInfoProtos.UserInfo();
    }

    public static com.zkartmod.UserInfoProtos.UserInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<UserInfo>
        PARSER = new com.google.protobuf.AbstractParser<UserInfo>() {
      @java.lang.Override
      public UserInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new UserInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<UserInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<UserInfo> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.zkartmod.UserInfoProtos.UserInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_zkart_UserInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_zkart_UserInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016userinfo.proto\022\005zkart\"\202\001\n\010UserInfo\022\014\n\004" +
      "mail\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\023\n\013phoneNumber\030" +
      "\003 \001(\t\022\025\n\rnoOfPurchases\030\004 \001(\005\022\024\n\014discount" +
      "Code\030\005 \001(\t\022\030\n\020discountValidity\030\006 \001(\005B\036\n\014" +
      "com.zkartmodB\016UserInfoProtosb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_zkart_UserInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_zkart_UserInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_zkart_UserInfo_descriptor,
        new java.lang.String[] { "Mail", "Name", "PhoneNumber", "NoOfPurchases", "DiscountCode", "DiscountValidity", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}